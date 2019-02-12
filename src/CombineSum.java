import java.util.ArrayList;
import java.util.List;

public class CombineSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> cn = new ArrayList<>();
        for(int i=0; i<candidates.length;i++) {
            findCN(new ArrayList<>(cn), 0, i, candidates, target, result);
        }
        return result;
    }

    private void findCN(List<Integer> pcn, int cum, int index, int[] candidates, int target, List<List<Integer>> result) {
        if (cum + candidates[index] == target) {
            pcn.add(candidates[index]);
            result.add(new ArrayList(pcn));
            pcn.remove(pcn.size()-1);
            return;
        }
        if(cum+candidates[index]>target){
            return;
        }
        if(cum+candidates[index]<target){
            pcn.add(candidates[index]);
            cum = cum+candidates[index];
            for(int i=index; i<candidates.length; i++)
                findCN(pcn, cum, i, candidates, target, result);
            if(pcn.size()>0) {
                pcn.remove(pcn.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombineSum c = new CombineSum();
        c.combinationSum(new int[]{2,3,5},8);
    }

}

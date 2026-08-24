class Solution:
    def combinationSum(self, candidate: List[int], target: int) -> List[List[int]]:
        result=[];
        self.backtrack(candidate,target,0,[],result);
        return result;
    
    def backtrack(self,candidate:List[int], target:int, start:int, temp:List[int], result:List[int]):
        if target==0:
            result.append(list(temp));
            return;
        
        for i in range(start, len(candidate)):
            if target>=candidate[i]:
                temp.append(candidate[i]);
                self.backtrack(candidate, target-candidate[i],i,temp,result);
                temp.pop();
        
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result=[]

        def backtrack(current:str, open_count:int, close_count:int, max_count:int):
            if len(current)==max_count*2:
                result.append(current);
                return;
            
            if open_count<max_count:
                backtrack(current+"(",open_count+1,close_count,max_count);

            if close_count<open_count:
                backtrack(current+")",open_count,close_count+1,max_count)
            
        backtrack("",0,0,n)
        return result
public class Solution {

    List<int> index = new List<int>();
    public string Encode(IList<string> strs) {
        if(strs.Count == 0){
            index.Add(-1);
            return "";
        }
        string str = "";
        int i = 0;
        foreach(string s in strs){
            index.Add(i);
            i += s.Length;
            str += s;
        }
        return str;
    }

    public List<string> Decode(string s) {
        List<string> ans = new List<string>();
        if(index[0] == -1){
            return ans;
        }
        if(index.Count <= 1){
            ans.Add(s);
            return ans;
        }
        int prevIndex = 0;
        for(int i = 1; i < index.Count; i++){
            ans.Add(s.Substring(prevIndex,index[i]-prevIndex));
            prevIndex = index[i];
        }
        ans.Add(s.Substring(prevIndex));
        return ans;
   }
}

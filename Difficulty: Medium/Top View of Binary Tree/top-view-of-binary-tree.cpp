class Solution {
  public:
    vector<int> topView(Node *root) {
        // code here
        vector<pair<int,int>> temp;
        queue<pair<Node*,int>> q;
        set<int> s;
        q.push({root,0});
        while(q.empty()!=true){
            int a=q.size();
            while(a){
                pair<Node*,int> b=q.front();
                q.pop();
                if(s.find(b.second)==s.end()){
                    temp.push_back({b.second,b.first->data});
                    s.insert(b.second);
                }
                if(b.first->left!=NULL){
                    q.push({b.first->left,b.second-1});
                }
                if(b.first->right!=NULL){
                    q.push({b.first->right,b.second+1});
                }
                a--;
            }
        }
        sort(temp.begin(),temp.end());
        vector<int> ans;
        for(int i=0;i<temp.size();i++){
            ans.push_back(temp[i].second);
        }
        return ans;
    }
};
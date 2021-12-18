#include<bits/stdc++.h>
using namespace std;
#define int long long int

bool Comparestart(const pair<int, int> &l, const pair<int, int> &r)
{
  return l.first < r.first;
}

bool Compareend (const pair<int, int> &l, const pair<int, int> &r)
{
  return l.second < r.second;
}


int32_t main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int32_t n;
    cin>>n;
    vector<pair<int,int>> v;
    int x; int y;
    int32_t N = n;
    while(n--){
    	cin>>x;cin>>y;
    	v.push_back(make_pair(x,y));
    }
    sort(v.begin(), v.end(), &Comparestart);
    sort(v.begin(), v.end(), &Compareend);
   	int count=0; int maxCount =1; int currTime =0;
   	for(int i=0;i<v.size();i++){
   		if(v[i].first >= currTime){
   			count++;
            currTime = v[i].second;
   		}
        maxCount = max(count,maxCount);
   	}
   	cout<<maxCount<<endl;
    return 0;
}
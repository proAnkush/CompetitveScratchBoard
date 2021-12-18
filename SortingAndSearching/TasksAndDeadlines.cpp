#include <iostream>
#include<bits/stdc++.h>


using namespace std;
int main(){
    long long n;
    long long a, b;
    cin >> n;
    vector< pair <long long,long long> > p;
    for(int i = 0 ; i < n; i++){
        
        cin >> a >> b;
        p.push_back(make_pair(a, b));
    }
    sort(p.begin(), p.end());
    long long currTime = 0;
    long long profit = 0;
    for(auto t : p){
        currTime += t.first;
        profit += t.second - currTime;
    }
    cout << profit;
}
#include <iostream>
#include <bits/stdc++.h>
#include <vector>
using namespace std;
int binSearch(vector<long long> a, long long key){
    int l = 0;
    int r = a.size()-1;
    int ans = l;
    while(l <= r){
        int mid = (l + r)/2;
        if(a[mid] == key){
            return mid;
        }
        else if(a[mid] < key){
            ans = mid;
            l = mid+1;
        }
        else{
            r = mid-1;
        }
    }
    if(a[ans] <= key) return ans;
    return -1;
}
int main(){
    int n, m;
    cin >> n >> m;
    vector<long long> a(n);
    long long b[m];
    for(int i = 0 ; i < n; i++){
        long long x;
        cin >> x;
        a.push_back(x);
    }
    for(int i = 0 ; i < m; i++){
        cin >> b[i];
    }
    sort(a.begin(), a.end());
    for(int i = 0 ; i < m; i++){
        if(a.size()==0){
            cout << "-1";
            continue;
        }
        int x = binSearch(a, b[i]);
        if(x == -1){
            cout << "-1";
        }
        else{
            if(a[x] == 0){ 
                cout << "-1 "; continue;
            }
            cout << a[x] << endl;
            a.erase(a.begin() +x);
        }
    }


}

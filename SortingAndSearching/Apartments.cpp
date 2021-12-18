#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n, m, k;
    cin >> n >> m >> k;
    int a[n];
    int b[m];
    for(int i = 0 ; i < n; i++){
        cin >> a[i];
    }
    for(int i = 0 ; i < m; i++){
        cin >> b[i];
    }
    int i=0, j=0, count=0;
    sort(a, a+n);
    sort(b, b+m);

    while(i < n && j < m){
        if(a[i] >= b[j]-k && a[i] <= b[j]+k){
            count++;
            j++;
            i++;
        }else{
            if(a[i] > b[j]+k){
                j++;
            }else{
                i++;
            }
        }
    }
    cout << count;

}
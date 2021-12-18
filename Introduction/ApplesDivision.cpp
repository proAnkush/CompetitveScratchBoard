#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    long long a[n];
    for(int i = 0 ; i < n; i++){
        cin >> a[i];
    }
    sort(a, a+n);
    long long g1 = 0;
    long long g2 = 0;
    for(int i = 0; i < n; i++){
        if(g2 < g1){
            g2 += a[i];
        }else{
            g1 += a[i];
        }
        if(g1 == g2){
            g1 = 0;
            g2 = 0;
        }
    }
    cout << abs(g2 - g1);

}
#include <iostream>
using namespace std;
int main(){
    int t ;
    cin >> t;
    while(t--){

        long long a;
        cin >> a;
        long long b;
        cin >> b;
        if(a < b) swap(a,b);
        if(a > 2*b) cout << "NO" << endl;
        else{
            a%=3, b%=3;
            if(a < b) swap(a, b);
            if((a== 2 && b == 1) || (a==b&& b==0)){
                cout << "YES" << endl;
            }else{
                cout << "NO" << endl;
            }
        }
    }
}

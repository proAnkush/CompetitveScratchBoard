#include <iostream>
using namespace std;

/**
 * TwoKnights
 */
int main(){
        long long n;
        cin >> n;
        cout << 0 << " ";
        for(long long i = 2; i <= n; i++){
            long long ans = (((i*i) * (i*i-1) )/ 2) - (4*(i-2)*(i-1));
            cout << ans << " ";
        }

}
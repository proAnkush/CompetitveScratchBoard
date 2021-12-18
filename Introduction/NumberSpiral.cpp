#include <iostream>
using namespace std;
int main(){
    long long t;
    long long x;
    long long y;
    long long r;
    cin >> t;
    while(t--){
        cin >> x >> y;
        if(x < y){
            if(y % 2 == 1){
                r = y*y;
                cout << r - x + 1 << endl;
            }else{
                r = ((y-1)*(y-1))+1;
                cout << r + x -1 << endl;
            }
        }else{
            if(x % 2 == 0){
                r = (x*x);
                cout << r - y+1 << endl;
            }else{
                r = ((x-1) * (x-1)) +1;
                cout << r + y -1 << endl;
            }
        }
    }
}
    


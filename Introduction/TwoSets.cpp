#include <iostream>
#include <stack>
using namespace std;
int main(){
    int n;
    cin >> n;   
    if(((n*(n+1))/2)%2== 0){
            cout << "YES" << endl;
            stack<int> s1;
            stack<int> s2;
            long a, b; a = b= 0;
            while(n > 0){
                if(a <= b){
                    a+=n;
                    s1.push(n);
                }else{
                    b+=n;
                    s2.push(n);
                }
                n--;
            }
            cout << endl;
            cout << s1.size() << endl;
            while(!s1.empty()){
                cout << s1.top() << " ";
                s1.pop();
            }

            cout << endl;
            cout << s2.size() << endl;
            while(!s2.empty()){
                cout << s2.top() << " ";
                s2.pop();
            }
        }else{
            cout << "NO";
        }


    
}
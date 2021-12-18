#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;   
    if(n == 1){
        cout << 1 << endl;
        return 0;
    }else if(n <= 3){
        cout << "NO SOLUTION" << endl;
        return 0;
    }else if(n == 4){
        cout << "2 4 1 3" << endl;
        return 0;
    }
    int eN = (n %2 == 0) ? n : n-1;
    while(eN >= 1){
        cout << eN << " ";
        eN -= 2;
    }
    eN = (n %2 == 1) ? n : n-1;
    while (eN >= 1)
    {
        cout << eN << " ";
        eN -= 2;
    }

    
}
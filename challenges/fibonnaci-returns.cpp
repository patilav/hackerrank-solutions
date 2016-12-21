#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void fibonacci(long long fibo[100], int num){
    int i;
    for(i=2;i<=num;i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
    }
    cout<< fibo[num];
}

int main() {
    int num;
    long long fibo[100];
    fibo[0]=0;
    fibo[1]=1;
    while(cin >> num){
        fibonacci(fibo,num);
        cout<< "\n";
    }
    return 0;
}

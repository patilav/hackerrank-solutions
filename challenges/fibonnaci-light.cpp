#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void fibonacci(int num){
    int a=0;
    int b=1;
    int fib=a+b;
    int i;
    for(i=2;i<=num;i++){
        fib=a+b;
        a=b;
        b=fib;
    }
    if (num<2){
        cout<< num;
    } else {
        cout<< fib;
    }
}

int main() {
    int num;
    cin >> num;
    fibonacci(num);
    return 0;
}

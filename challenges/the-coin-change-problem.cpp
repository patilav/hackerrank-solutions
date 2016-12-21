#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long coin_calc(vector<int> coins, int total_sum){
   vector<long> memo(total_sum+1);
   memo[0] = 1;
   for(long coin: coins) {
       for(int i=coin; i<=total_sum;i++){
           memo[i]+=memo[i-coin];
       }
   }
    return memo[total_sum];
}


int main() {
    int total_sum, ncoin;
    int total_coins;
    vector<int> coins;
    cin >> total_sum >> total_coins;
    for(int i=0;i<total_coins;i++) {
        cin>> ncoin;
        coins.push_back(ncoin);
    }
    
    cout<< coin_calc(coins, total_sum);
    
    return 0;
}

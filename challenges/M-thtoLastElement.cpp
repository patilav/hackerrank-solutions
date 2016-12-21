#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

struct Node{
    int data;
    struct Node *next, *prev;
};

typedef struct Node node;

node* insert_after_node(int data, node *p){
    node* n =  (struct Node*) malloc (sizeof(struct Node));  
    n->data = data;
    n->next = NULL;
    n->prev = p;
    if (p!=NULL) {
        p->next = n;        
    }
    return n;
}

void find_number(node *head, node *current, int nfind, int length) {
    int m = 0;
    if(nfind==0 || length==0){
        cout<< "NIL";
    }
    m=length-nfind;
    //cout <<" length " << length <<  " nfind " << nfind <<  " mvlj " << m<< "\n";
    if (m<0) {
        cout<< "NIL";
    } else {
        if (m<nfind){
            node *temp = head; 
            while(temp!=NULL && m!=0){
                temp=temp->next;
                m--;
            }
            if (temp!=NULL)
                cout<< temp->data;
            else 
                cout<< "NIL";
        } else {
            node *temp = current;
            nfind--;
            while(temp!=NULL && nfind!=0){
                temp=temp->prev;
                nfind--;
            }
            if (temp!=NULL)
                cout<< temp->data;
            else 
                cout<< "NIL";
        }
    }
}


int main() {
    int nfind;
    int input;
    int length = 0;
    node *head = NULL;
    node *current = NULL;
    int m = 0;
    cin >> nfind;    
    while (cin >> input){
        //cout << input;
          current = insert_after_node(input,current);
          if(head==NULL){
              head = current;
          }
        length++;
    }    
    find_number(head,current,nfind,length);
    return 0;
}

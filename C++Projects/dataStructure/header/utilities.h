#ifndef __UTILITIES_H
#define __UTILITIES_H
#include"definitionOfDataStructure.h"
#include<stdlib.h>
#include<iostream>

BTNode* getTree();
MGraph* getMGraph();
AGraph* getAGraph();
int* getRandomArray(int length,int minOfNumber,int maxOfNumber);
int* getRandomArray(int length,int maxOfNumber);
int* getRandomArray(int length);
#endif

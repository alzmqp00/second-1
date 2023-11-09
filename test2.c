#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <stdbool.h>
int main()
{
    // char a[10];
    char *expression = (char *)malloc(10);
    bool findDigit = false;
    fgets(expression, 10, stdin);
    printf("%d\n", strlen(expression));
    int len = strlen(expression);

    printf("%c", *(expression + 5));
    // printf("%ld\n", atof(expression + i));

    return 0;
}
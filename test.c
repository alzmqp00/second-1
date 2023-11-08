#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#define MAX_EXPRESSION_LENGTH 100
int OperaotStack[100];
int Priority(char op)
{
    if (op == '^')
        return 3;
    else if (op == '*' || op == '/' || op == '%')
        return 2;
    else if (op == '+' || op == '-')
        return 1;
    return 0;
}

double Operation(double operand1, char op, double operand2)
{
    switch (op)
    {
    case '+':
        return operand1 + operand2;
    case '-':
        return operand1 - operand2;
    case '*':
        return operand1 * operand2;
    case '/':
        return operand1 / operand2;
    case '%':
        return fmod(operand1, operand2);
    case '^':
        return pow(operand1, operand2);
    default:
        return 0.0;
    }
}

double calculate(char *expression)
{
    int i = 0;
    while ()
        if (*(expression + i))
}
int main()
{ // 564+48*((46-26)*99)
    char *expression = (char *)malloc(MAX_EXPRESSION_LENGTH);
    // char expression[100];
    while (1)
    {
        printf("輸入算式:\n");
        fgets(expression, MAX_EXPRESSION_LENGTH, stdin);

        for (int i = 0; i < 7; i++)
        {
            if (isdigit(*(expression + i)))
            {
                // 解析操作数
                operand = atof((expression + i));
                printf("结果: %lf\n", operand);
            }
        }
        free(expression);
    }

    return 0;
}

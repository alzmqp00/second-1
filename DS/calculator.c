#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#define MAX_EXPRESSION_LENGTH 100

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
// 100%3+2*6-(5/5)
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
    int OperaorStack[100];
    int OperaorStackTop = -1;
    double OperandStack[100];
    int OperandStackTop = -1;

    int len = strlen(expression);
    for (int i = 0; i < len - 1; i++)
    {
        if (isdigit(*(expression + i)))
        {
            OperandStack[++OperandStackTop] = atof(expression + i);
            while (i < len && (isdigit(expression[i]) || expression[i] == '.'))
            {
                i++;
            }
            i--; // For迴圈會再加一次
            // 跳過已經存取過的數字
        }
        else if (*(expression + i) == '(')
        {

            OperaorStack[++OperaorStackTop] = *(expression + i);
        }
        else if (*(expression + i) == ')')
        {
            // 找上一個左括號 彈出之中的運算子
            while (OperaorStack[OperaorStackTop] != '(')
            {
                double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
                OperandStack[++OperandStackTop] = temp;
                // 注意不是OperandStack[OperandStackTop++]
            }
            OperaorStackTop--;
        }
        else if (*(expression + i) != '.' && !isdigit(*(expression + i)))
        {
            // 彈出直到找到優先及更小的
            if (OperaorStackTop != -1 && Priority(*(expression + i)) <= Priority(OperaorStack[OperaorStackTop]))
            {
                while (OperaorStackTop != -1 && Priority(*(expression + i)) <= Priority(OperaorStack[OperaorStackTop]))
                {

                    double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
                    OperandStack[++OperandStackTop] = temp;
                }
                OperaorStack[++OperaorStackTop] = *(expression + i);
            }
            else
            {
                OperaorStack[++OperaorStackTop] = *(expression + i);
            }
        }
    }
    // 處理最後剩下的堆疊
    while (OperaorStackTop != -1)
    {
        double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
        OperandStack[++OperandStackTop] = temp;
    }
    return OperandStack[0];
}
int main()
{
    printf("Expressions can contain parentheses, and operators include +, -, *, /, %%, and ^. Operands must be positive numbers.\n");
    while (1)
    {
        char *expression = (char *)malloc(MAX_EXPRESSION_LENGTH);
        printf("Enter an expression:\n");
        fgets(expression, MAX_EXPRESSION_LENGTH, stdin);
        printf("Result:%lf\n", calculate(expression));
        free(expression);
    }

    return 0;
}
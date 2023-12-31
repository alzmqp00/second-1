#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <stdbool.h>
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
{ // 564+48*((46-26)*(99^3+33)

    int OperaorStack[100];
    int OperaorStackTop = -1;
    double OperandStack[100];
    int OperandStackTop = -1;

    bool findDigit = false;
    int len = strlen(expression);
    for (int i = 0; i < len - 1; i++)
    {
        if (isdigit(*(expression + i)) && findDigit == false)
        {
            OperandStack[++OperandStackTop] = atof(expression + i);
            findDigit = true;
            // printf("%lf      %d\n", atof(expression + i), i);
        }
        else if (*(expression + i) == '(')
        {
            findDigit = false;
            OperaorStack[++OperaorStackTop] = *(expression + i);
        }
        else if (*(expression + i) == ')')
        {
            findDigit = false;
            while (OperaorStack[OperaorStackTop] != '(')
            {
                double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
                OperandStack[++OperandStackTop] = temp;
                // printf(" %lf %c %d\n", temp, *(expression + i), i);
            }
            OperaorStackTop--;
        }
        else if (*(expression + i) != '.' && !isdigit(*(expression + i)))
        {

            findDigit = false;
            if (OperaorStackTop != -1 && Priority(*(expression + i)) <= Priority(OperaorStack[OperaorStackTop]))
            {
                while (OperaorStackTop != -1 && Priority(*(expression + i)) <= Priority(OperaorStack[OperaorStackTop]))
                {

                    double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
                    OperandStack[++OperandStackTop] = temp;
                }
                OperaorStack[++OperaorStackTop] = *(expression + i);
                // OperaorStack[OperaorStackTop] = *(expression + i); ->錯誤 100%3+2*7 OperaorStackTop=-1
            }
            else
            {
                OperaorStack[++OperaorStackTop] = *(expression + i);
            }
        }
        /* for (int j = 0; j <= OperandStackTop; j++)
         {
             printf("%lf ", OperandStack[j]);
         }
         printf("\n");*/
    }
    while (OperaorStackTop != -1)
    {
        double temp = Operation(OperandStack[OperandStackTop--], OperaorStack[OperaorStackTop--], OperandStack[OperandStackTop--]);
        OperandStack[++OperandStackTop] = temp;
        // printf(" %lf %c %d\n", temp, *(expression + i), i);
    }
    return OperandStack[0];
}
int main()
{ // 564+48*((46-26)*99)

    // char expression[100];
    printf("運算式裡可以有括號，Operators包含+、-、：*、/、%、^，Operands most be positive\n");
    while (1)
    {
        char *expression = (char *)malloc(MAX_EXPRESSION_LENGTH);
        printf("輸入算式:\n");
        fgets(expression, MAX_EXPRESSION_LENGTH, stdin);
        printf("Ans:%lf\n", calculate(expression));
        free(expression);
    }

    return 0;
}

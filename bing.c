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
    int OperatorStack[100];
    int OperatorStackTop = -1;
    double OperandStack[100];
    int OperandStackTop = -1;

    int len = strlen(expression);
    for (int i = 0; i < len; i++)
    {
        if (isdigit(expression[i]))
        {
            OperandStack[++OperandStackTop] = strtof(expression + i, NULL);
            while (i < len && (isdigit(expression[i]) || expression[i] == '.'))
            {
                i++;
            }
            i--;
        }
        else if (expression[i] == '(')
        {
            OperatorStack[++OperatorStackTop] = expression[i];
        }
        else if (expression[i] == ')')
        {
            while (OperatorStack[OperatorStackTop] != '(')
            {
                double operand2 = OperandStack[OperandStackTop--];
                char op = OperatorStack[OperatorStackTop--];
                double operand1 = OperandStack[OperandStackTop--];
                double temp = Operation(operand1, op, operand2);
                OperandStack[++OperandStackTop] = temp;
            }
            OperatorStackTop--;
        }
        else if (expression[i] != '.' && !isdigit(expression[i]))
        {
            while (OperatorStackTop != -1 && Priority(expression[i]) <= Priority(OperatorStack[OperatorStackTop]))
            {
                double operand2 = OperandStack[OperandStackTop--];
                char op = OperatorStack[OperatorStackTop--];
                double operand1 = OperandStack[OperandStackTop--];
                double temp = Operation(operand1, op, operand2);
                OperandStack[++OperandStackTop] = temp;
            }
            OperatorStack[++OperatorStackTop] = expression[i];
        }
    }

    while (OperatorStackTop != -1)
    {
        double operand2 = OperandStack[OperandStackTop--];
        char op = OperatorStack[OperatorStackTop--];
        double operand1 = OperandStack[OperandStackTop--];
        double temp = Operation(operand1, op, operand2);
        OperandStack[++OperandStackTop] = temp;
    }

    return OperandStack[0];
}

int main()
{
    printf("運算式裡可以有括號，Operators包含+、-、*、/、%、^，Operands most be positive\n");
    while (1)
    {
        char *expression = (char *)malloc(MAX_EXPRESSION_LENGTH);
        printf("輸入算式:\n");
        fgets(expression, MAX_EXPRESSION_LENGTH, stdin);
        printf("%lf\n", calculate(expression));
        free(expression);
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#define MAX_EXPRESSION_LENGTH 100

// 定义运算符的优先级
int getOperatorPriority(char op)
{
    if (op == '^')
        return 3;
    else if (op == '*' || op == '/' || op == '%')
        return 2;
    else if (op == '+' || op == '-')
        return 1;

    return 0;
}

// 执行二元运算
double performOperation(double operand1, char op, double operand2)
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

// 计算表达式
double evaluateExpression(char *expression)
{ // 2 + 3 * (4 - 1)
    int len = strlen(expression);
    double operandStack[MAX_EXPRESSION_LENGTH];
    char operatorStack[MAX_EXPRESSION_LENGTH];
    int operandTop = -1;
    int operatorTop = -1;

    for (int i = 0; i < len; i++)
    {
        if (isdigit(expression[i]))
        {
            // 解析操作数
            double operand = atof(expression + i);

            printf("%lf\n", operand);
            operandStack[++operandTop] = operand;
            while (i < len && (isdigit(expression[i]) || expression[i] == '.'))
            {
                i++;
            }
            i--;
        }
        else if (expression[i] == '(')
        {
            operatorStack[++operatorTop] = expression[i];
        }
        else if (expression[i] == ')')
        {
            while (operatorTop >= 0 && operatorStack[operatorTop] != '(')
            {
                double operand2 = operandStack[operandTop--];
                double operand1 = operandStack[operandTop--];
                char op = operatorStack[operatorTop--];
                operandStack[++operandTop] = performOperation(operand1, op, operand2);
            }
            operatorTop--; // 弹出左括号
        }
        else if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' ||
                 expression[i] == '/' || expression[i] == '%' || expression[i] == '^')
        {
            // 处理运算符
            while (operatorTop >= 0 && getOperatorPriority(expression[i]) <= getOperatorPriority(operatorStack[operatorTop]))
            {
                double operand2 = operandStack[operandTop--];
                double operand1 = operandStack[operandTop--];
                char op = operatorStack[operatorTop--];
                operandStack[++operandTop] = performOperation(operand1, op, operand2);
            }
            operatorStack[++operatorTop] = expression[i];
        }
    }

    // 处理剩余的运算符和操作数
    while (operatorTop >= 0)
    {
        double operand2 = operandStack[operandTop--];
        double operand1 = operandStack[operandTop--];
        char op = operatorStack[operatorTop--];
        operandStack[++operandTop] = performOperation(operand1, op, operand2);
    }

    // 最终结果在操作数栈中
    return operandStack[0];
}

int main()
{
    char *expression = (char *)malloc(MAX_EXPRESSION_LENGTH);
    // char expression[MAX_EXPRESSION_LENGTH];
    printf("请输入数学表达式: ");
    fgets(expression, MAX_EXPRESSION_LENGTH, stdin);

    // 删除换行符
    expression[strcspn(expression, "\n")] = '\0';

    double result = evaluateExpression(expression);
    printf("结果: %lf\n", result);

    return 0;
}

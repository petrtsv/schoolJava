package com.epam.javacourses2016.task8;

import java.util.Stack;

/**
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class SolverTask8 {

    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     *      1) Каждой открывающей скобке соответствует закрывающая того же типа.
     *      2) Нет пересечения областей, обрамленных скобками.
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string)
    {
        Stack<Character> stack = new Stack<Character>();
        String open = "([{";
        String close = ")]}";
        boolean result = true;
        for (char chr : string.toCharArray())
        {
            if (open.indexOf(chr) != -1)
            {
                stack.add(chr);
            } else if (close.indexOf(chr) != -1)
            {
                if (stack.empty() || open.indexOf(stack.lastElement()) != close.indexOf(chr))
                {
                    result = false;
                }
                if (!stack.empty())
                {
                    stack.pop();
                }
            }
        }
        if (stack.size() > 0)
        {
            result = false;
        }

        return result;
    }
}

# Тестовое задание.

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Требования к решению:
1. Java 8+
2. Spring boot 2+
3. Решение должно быть покрыто тестами
4. У решения должна быть документация по запуску и формату входящих/исходящих параметров
5. Код решения необходимо разместить в публичном Github репозитории.


# REST API для вычисления частоты встречи символов
Это REST API позволяет вычислить частоту встречи символов в заданной строке. Результат сортируется в порядке убывания количества вхождений символов в строку.
## Эндпоинты API
**/calculateFrequency**
* Метод: POST
* Описание: Вычисляет частоту встречи символов в заданной строке.
* Входящие параметры:
  * input (строка): Строка для анализа частоты символов.
* Исходящие параметры:
  * JSON-объект с частотой символов.
  * > [!NOTE]
  * > Если использовать специальные символы Java - '\','"' и т.д., то символы будут содержать дополнительно '\'.
    
* Возможные ошибки:
  * 400 Bad Request: Если строка пуста, содержит более 10 000 символов или содержит символы новой строки (\n) или возврата каретки (\r).
## Формат входящих параметров
* input (строка): Строка, для которой нужно вычислить частоту встречи символов.
* Допустимая длина строки: от 1 до 10 000 символов.
* Строка не должна содержать символы новой строки (\n) или возврата каретки (\r).
## Формат исходящих параметров
* JSON-объект, содержащий символы и их частоту встречи в строке. Результат отсортирован по убыванию частоты вхождений.
* > [!Warning]
* > Если использовать специальные символы Java - '\','"' и т.д., то символы будут содержать дополнительно '\'.

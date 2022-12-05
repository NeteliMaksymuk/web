# Web
Laboratory from the WEB applications course


# Завдання:
1) Розробити архітектуру системи згідно з варіантом завдання (побудувати за
   архітектурним шаблоном проектування MVC з використанням шаблонів проектування GoF).
2) Розробити та створити БЗ для системи згідно варіанту завдання.
3) Написати програму на мові Java, що реалізує систему за розробленою архітектурою з
   доступом до БД через інтерфейс DAO

# Варіант 7. Лікарня
Адміністратору системи доступний список Лікарів за категоріями (педіатр, травматолог,
хірург, ...) і список Пацієнтів. Реалізувати можливість сортування:
### 1) пацієнтів:
- за алфавітом;


- за датою народження;
### 2) лікарів:
- за алфавітом;


- за категорією;


- за кількістю пацієнтів.

Адміністратор реєструє в системі пацієнтів і лікарів і призначає пацієнтові лікаря.
Лікар визначає діагноз, робить призначення пацієнту (процедури, ліки, операції), які
фіксуються в Лікарняній картці. Призначення може виконати Медсестра (процедури, ліки) або
Лікар (будь-яке призначення).
Пацієнт може бути виписаний з лікарні, при цьому фіксується остаточний діагноз.
(Опціонально: реалізувати можливість збереження / експорта документа з інформацією про
виписку пацієнта).



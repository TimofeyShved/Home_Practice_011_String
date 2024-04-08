# Строки 

5.0. Частотный словарь букв русского (или английского) алфавита.

Можно найти очень много задач на строки. Например:

Задача
--------

Напишите метод для поиска самой длинной строки в массиве.

Решение:
--------
    public static String maxString(String[] s1){
        String max = "";
        for (String s : s1){
            if (max.length() < s.length()){
                max = s;
            }
        }
        return max;
    }

Задача
--------

Напишите метод, который проверяет является ли слово палиндромом.

Решение:
--------

    public static boolean polindrom(String s1, String s2){
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }

Задача
--------

Напишите метод, заменяющий в тексте все вхождения слова Навальный «бяка» на «[вырезано
цензурой]».

Решение:
--------
    public static String cenzur(String[] banList, String s1){
        for (String s: banList){
            s1 = s1.replaceAll(s, "[вырезано цензурой]");
        }
        return s1;
    }

Задача
--------
Имеются две строки. Напишите метод, возвращающий количество вхождений одной строки в другую.

Решение:
--------

    public static int occurrences(String str, String substr) {
        int occurrences = 0;
        int index = str.indexOf(substr);
        while (index != -1) {
            occurrences++;
            index = str.indexOf(substr, index + 1);
        }
        return occurrences;
    }

Задача
--------

Постройте частотный словарь букв русского (или английского) алфавита. Опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст небольшой длины).

Решение:
--------

    /**
     * Будем перебирать все символы в строке, и
     * если это символ алфавита русского языка,
     * обновляем значение в Map.
     *
     * Потом возьмём все Map.Entry<Character, Integer>,
     * и отсортируем по ключу (Character)
     *
     * @param text - текст
     */
    void buildDictionaryWithMap(String text){
        text = text.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);

            // ё идёт отдельно от а-я
            if((ch >= 'а' && ch <= 'я') || ch == 'ё'){
                map.compute(ch, (character, integer)
                        -> integer == null ? 1 : integer + 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> entries =
                new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

Или так:

    /**
     * Вариант без Map.
     * Создадим массив нужной длины, и будем хранить
     * в соответствующих позициях количество вхождений
     * символов
     * @param text
     */
    void buildDictionary(String text){
        text = text.toLowerCase();

        int[] result = new int['я' - 'а' + 1];
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch >= 'а' && ch <= 'я'){
                result[ch - 'а']++;
            }
        }

        for(int i = 0; i < result.length; i++){
            System.out.println((char) (i + 'а') + " = " + result[i]);
        }
    }

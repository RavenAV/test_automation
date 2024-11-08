# language: ru
@withdrawal
Функция: Калькулятор

Предыстория:
  Дано таблица calculations содержит
    | first_number | first_base      | second_number | second_base    | operation_type | calculation_datetime   |
    | 10           | DECIMAL         | 10            | BINARY         | ADDITION       | 2024-11-01T12:00:00    |
    | 25           | HEXADECIMAL     | 20            | OCTAL          | SUBTRACTION    | 2024-11-01T12:00:00    |
    | 7            | OCTAL           | 20            | DECIMAL        | MULTIPLICATION | 2024-11-01T12:00:00    |
    | 15           | DECIMAL         | 1             | HEXADECIMAL    | DIVISION       | 2024-11-02T12:00:00    |
    | 4            | OCTAL           | 1             | BINARY         | ADDITION       | 2024-11-02T12:00:00    |
    | 35           | HEXADECIMAL     | 1             | OCTAL          | SUBTRACTION    | 2024-11-03T12:00:00    |
    | 11           | DECIMAL         | 1             | DECIMAL        | MULTIPLICATION | 2024-11-03T12:00:00    |
    | 28           | DECIMAL         | 1             | HEXADECIMAL    | DIVISION       | 2024-11-03T12:00:00    |
    | 22           | DECIMAL         | 1             | BINARY         | ADDITION       | 2024-11-04T12:00:00    |
    | 21           | HEXADECIMAL     | 1             | OCTAL          | SUBTRACTION    | 2024-11-04T12:00:00    |
    | 21           | DECIMAL         | 1             | DECIMAL        | MULTIPLICATION | 2024-11-04T12:00:00    |
    | 25           | DECIMAL         | 1             | HEXADECIMAL    | DIVISION       | 2024-11-04T12:00:00    |
    | 26           | HEXADECIMAL     | 1             | BINARY         | ADDITION       | 2024-11-05T12:00:00    |
    | 2            | OCTAL           | 1             | OCTAL          | SUBTRACTION    | 2024-11-05T12:00:00    |
    | 85           | DECIMAL         | 1             | DECIMAL        | MULTIPLICATION | 2024-11-05T12:00:00    |
    | 58           | HEXADECIMAL     | 1             | HEXADECIMAL    | DIVISION       | 2024-11-05T12:00:00    |
    | 24           | DECIMAL         | 1             | BINARY         | ADDITION       | 2024-11-06T12:00:00    |
    | 4            | OCTAL           | 2             | OCTAL          | SUBTRACTION    | 2024-11-06T12:00:00    |
    | 17           | DECIMAL         | 25            | DECIMAL        | MULTIPLICATION | 2024-11-06T12:00:00    |
    | 19           | HEXADECIMAL     | 45            | HEXADECIMAL    | DIVISION       | 2024-11-06T12:00:00    |

  @success
  Сценарий: Успешное получение вычислений
    Когда запрашиваем вычисления с параметрами
      | start         | 2024-11-01T11:00:00 |
      | end           | 2024-11-02T12:00:00 |
      | firstBase     | DECIMAL             |
      | secondBase    | BINARY              |
      | operationType | ADDITION            |

    Тогда ответ получения вычислений
		"""
		[
		    {
		        "id": 1506,
		        "firstNumber": "10",
		        "firstBase": "DECIMAL",
		        "secondNumber": "10",
		        "secondBase": "BINARY",
		        "operationType": "ADDITION",
		        "calculationDatetime": "2024-11-01T12:00:00"
		    }
		]
		"""

  @success
  Сценарий: Успешное получение вычислений (дата)
    Когда запрашиваем вычисления с параметрами (дата) 2024-11-01T11:00:00, 2024-11-02T12:00:00
      | firstBase     | DECIMAL              |
      | secondBase    | BINARY               |
      | operationType | ADDITION             |
    Тогда ответ получения вычислений (дата)
		"""
		[
		    {
		        "id": 1526,
		        "firstNumber": "10",
		        "firstBase": "DECIMAL",
		        "secondNumber": "10",
		        "secondBase": "BINARY",
		        "operationType": "ADDITION",
		        "calculationDatetime": "2024-11-01T12:00:00"
		    }
		]
		"""

  @success
  Сценарий: Успешное добавление вычисления
    Когда добавляем вычисление
		"""
		{
		    "firstNumber": "1010",
		    "secondNumber": "10",
		    "firstBase": "BINARY",
		    "secondBase": "BINARY",
		    "operationType": "ADDITION"
		}
		"""
    Тогда ответ добавления вычисления "1100"

  @success
  Сценарий: Успешное добавление вычисления (разделитель)
    Когда добавляем вычисление (разделитель) 1010 & 1 & BINARY & BINARY & ADDITION
    Тогда ответ добавления вычисления (разделитель) "1011"

  @success
  Сценарий: Успешное добавление вычисления (класс)
    Когда добавляем вычисление (класс) 1010 & 101 & BINARY & BINARY & ADDITION
    Тогда ответ добавления вычисления (класс) "1111"




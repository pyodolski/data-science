# person 객체를 하나만들고
# 생성자에 이름과 나이, 주소를 받을 수 있도록 생성자를 정의하고
# 함수로 자신의 이름과 함께 '안녕하세요 저는 김민 입니다.' 
# 출력할 수 있는 함수를 하나 만드세요

class Person:

    def __init__(self, name, age, address): # *args도 가능
        self.name = name  # self.name, self.age, self.address = args도 가능
        self.age = age
        self.address = address

    def print_info(self):
        print(f'안녕하세요 저는 {self.name}입니다')


person = Person('표주원', 25, '대구광역시')
person.print_info()

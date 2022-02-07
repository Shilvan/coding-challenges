#Given a number, write a function to output its reverse digits. (e.g. given 123 the answer is 321)
#Numbers should preserve their sign; i.e. a negative number should still be negative when reversed.


def reverse_number(n):
    #Get n sign
    sign = "+"
    if (n < 0):
        sign = "-"
        
    #split n with abs so the minus sign doesn't appear in the list
    splittedN = list(str(abs(n)))
    
    #start with the sign
    reversedN = sign
    #reverse list and add to reversedN
    for digit in splittedN[::-1]:
        reversedN += digit
        
    #convert to integer
    return int(reversedN)

""" Better solution by someone else:
def reverseNumber(n):
    if n < 0: return -reverseNumber(-n)
    return int(str(n)[::-1])
"""

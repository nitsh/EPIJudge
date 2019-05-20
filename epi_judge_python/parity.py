from test_framework import generic_test


def parity(x):
    result = 0
    while x != 0:
        result += (x & 1)
        x >>= 1
    return result % 2


if __name__ == '__main__':
    exit(generic_test.generic_test_main("parity.py", 'parity.tsv', parity))

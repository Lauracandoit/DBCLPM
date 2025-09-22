def longest_repeated_substring(s: str) -> str:
    n = len(s)
    longest = ""
    # Duyệt tất cả substring
    for i in range(n):
        for j in range(i + 1, n + 1):
            sub = s[i:j]
            # Nếu sub xuất hiện ít nhất 2 lần
            if len(sub) > len(longest) and s.count(sub) > 1:
                longest = sub
    return longest


def count_words(s: str) -> int:
    return len(s.split())


def replace_substring(s: str, old: str, new: str) -> str:
    return s.replace(old, new)


# Demo
text = "hello world hello python"

print("Chuỗi gốc:", text)
print("Số từ:", count_words(text))
print("Chuỗi con dài nhất lặp lại:", longest_repeated_substring(text))
print("Thay thế 'hello' -> 'hi':", replace_substring(text, "hello", "hi"))

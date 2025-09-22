def longest_unique_substring(s):
    seen = {}
    start = max_len = 0
    longest = ""
    for i, char in enumerate(s):
        if char in seen and seen[char] >= start:
            start = seen[char] + 1
        seen[char] = i
        if i - start + 1 > max_len:
            max_len = i - start + 1
            longest = s[start:i+1]
    return longest

def word_count(s):
    return len(s.split())

def replace_substring(s, old, new):
    return s.replace(old, new)

# 🧪 Test
text = "hello world, welcome to the world of Python"
print("🔹 Chuỗi con dài nhất không lặp:", longest_unique_substring(text))
print("🔹 Số từ:", word_count(text))
print("🔹 Chuỗi sau khi thay thế:", replace_substring(text, "world", "universe"))

.data
str_1:  .asciz "Hello, RISC-V!\n" 
.global main
.text
main:
la x2, str_1
mv x3, zero
 # must put into x2 address of string
 # x3 - length counter, must be zero
 # x1 - resulted length will be here
strlen:
  lb x4, 0(x2)
  beqz x4, end_strlen
  addi x2, x2, 1
  addi x3, x3, 1
  j strlen
  end_strlen:
  addi x1, x3, 0
li a7, 64
li a0, 1
la a1, str_1
addi x1, x1, 1
addi a2, x1, 0
ecall
# exit
li a7, 93
ecall
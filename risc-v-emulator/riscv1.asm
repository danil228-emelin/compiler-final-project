.global main
.text
main:
    li x5, 1
    li x6, 4
while_start:
    blez x6, while_end  
    mul x5, x5, x6  
    addi x6, x6, -1
    j while_start
while_end:
    mv a0, x5       
    li a7, 1
    ecall
    li a0, 10       
    li a7, 11    
    ecall
    li a7, 93       
    ecall
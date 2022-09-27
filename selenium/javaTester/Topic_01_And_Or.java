package javaTester;

public class Topic_01_And_Or {

	public static void main(String[] args) {
		// Có 2 điều kiện
		// Kết hợp and hoặc or giữa 2 điều kiện này
		// Ra kết quả ( True/ False)
		boolean firtsCondition = true;
		boolean secondCondition = false;
		boolean result;
		
		// ADN: Nếu 1 trong 2 điều kiện mà sai = sai
		// Chỉ khi nào cả 2 đều đúng = đúng
		// ĐK 1 = 	TRUE	FALSE	TRUE	FALSE
		// ĐK 2 = 	FALSE	TRUE	TRUE	FALSE
		// Result = FALSE	FALSE	TRUE	FALSE
		firtsCondition = true;
		secondCondition = false;
		System.out.print(firtsCondition && secondCondition);
		
		firtsCondition = true;
		secondCondition = true;
		System.out.print(firtsCondition && secondCondition);
		
		firtsCondition = false;
		secondCondition = false;
		System.out.print(firtsCondition && secondCondition);
		
		firtsCondition = false;
		secondCondition = true;
		System.out.print(firtsCondition && secondCondition);
		
		// OR: Nếu 1 trong 2 điều kiện mà đúng = đúng
		// ĐK 1 = 	TRUE	FALSE	TRUE	FALSE
		// ĐK 2 = 	FALSE	TRUE	TRUE	FALSE
		// Result = TRUE	TRUE	TRUE	FALSE
		
		firtsCondition = true;
		secondCondition = false;
		System.out.print(firtsCondition || secondCondition);
		
		firtsCondition = true;
		secondCondition = true;
		System.out.print(firtsCondition || secondCondition);
		
		firtsCondition = false;
		secondCondition = false;
		System.out.print(firtsCondition || secondCondition);
		
		firtsCondition = false;
		secondCondition = true;
		System.out.print(firtsCondition || secondCondition);
	}

}

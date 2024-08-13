
const amountBtn = document.querySelectorAll("[name=amountBtn]");
const deleteBtn = document.querySelectorAll("[name=deleteBtn]");

for (let i = 0; i < arr.length; i++) {
  amountBtn[i].addEventListener("click", () => {
    const acc = prompt("누적할 금액을 입력하세요");
  
    if (acc == null) {
      alert("입력 취소");
      return;
    }

    if (isNaN(acc)) {
      alert("숫자만 입력해주세요");
      return;
    }

    if (acc < 0) {
      alert("0 이하의 금액은 누적할 수 없습니다")
      return;
    }
  
    location.href = "/member/amount?index=" + i + "&name=" + arr[i].name + "&acc=" + acc;
  
  
  });
  
  deleteBtn[i].addEventListener("click", () => {
  
    if (!confirm("정말 삭제 하시겠습니까?")) return;
  
    location.href = "/member/delete?index=" + i + "&name=" + arr[i].name;
  
  });
}     


const readBtn = document.querySelector("#readBtn");
const addBtn = document.querySelector("#addBtn");


readBtn.addEventListener("click", () => {
  location.href = "/member/read";
});

addBtn.addEventListener("click", () => {
  location.href = "/member/add";
});
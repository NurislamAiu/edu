document.addEventListener("DOMContentLoaded", function () {

    // Аккордеон
    const items = document.querySelectorAll("#faqAccordion .accordion-item");
    items.forEach((item) => {
      const btn = item.querySelector(".accordion-title");
      btn.addEventListener("click", function () {
        if (item.classList.contains("active")) {
          item.classList.remove("active");
          btn.querySelector(".icon").textContent = "+";
          item.querySelector(".accordion-content").style.display = "none";
        } else {
          items.forEach((i) => {
            i.classList.remove("active");
            i.querySelector(".icon").textContent = "+";
            i.querySelector(".accordion-content").style.display = "none";
          });
          item.classList.add("active");
          btn.querySelector(".icon").textContent = "−";
          item.querySelector(".accordion-content").style.display = "block";
        }
      });
    });

    // Teacher cards
    const cards = document.querySelectorAll(".teacher-card");
    cards.forEach((card) => {
      card.addEventListener("click", function (e) {
        cards.forEach((c) => c.classList.remove("active"));
        this.classList.add("active");
        e.stopPropagation();
      });
    });
    document.body.addEventListener("click", function () {
      cards.forEach((c) => c.classList.remove("active"));
    });
    document.querySelectorAll(".teacher-socials").forEach((social) => {
      social.addEventListener("click", function (e) {
        e.stopPropagation();
      });
    });

    // Video
    const video = document.getElementById("parentVideo");
    const playBtn = document.getElementById("playBtn");
    if (video && playBtn) {
      playBtn.addEventListener("click", function () {
        video.play();
        playBtn.classList.add("hide");
      });
      video.addEventListener("pause", function () {
        playBtn.classList.remove("hide");
      });
      video.addEventListener("ended", function () {
        playBtn.classList.remove("hide");
      });
      video.addEventListener("click", function () {
        if (!video.paused) {
          video.pause();
        }
      });
    }

    // Языковой переключатель
    document.querySelectorAll(".lang-btn").forEach((btn) => {
      btn.addEventListener("click", function () {
        setLang(this.dataset.lang);
        document
          .querySelectorAll(".lang-btn")
          .forEach((b) => b.classList.remove("active"));
        this.classList.add("active");
      });
    });

    const slides = document.querySelectorAll('.parent-slide');
        const dots = document.querySelectorAll('.parent-slider-dots .dot');

        function showSlide(index) {
          slides.forEach((slide, i) => {
            slide.classList.toggle('active', i === index);
            dots[i].classList.toggle('active', i === index);
          });
        }

        dots.forEach((dot, index) => {
          dot.addEventListener('click', () => showSlide(index));
        });

        Inputmask("+7 (999) 999-99-99").mask("#newsletter-phone");


  });

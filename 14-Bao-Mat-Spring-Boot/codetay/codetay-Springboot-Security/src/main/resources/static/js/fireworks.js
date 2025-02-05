document.addEventListener('DOMContentLoaded', function () {
    const canvas = document.createElement('canvas');
    document.body.appendChild(canvas);
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    const ctx = canvas.getContext('2d');

    function random(min, max) {
        return Math.random() * (max - min) + min;
    }

    function Firework(x, y) {
        this.x = x;
        this.y = y;
        this.radius = random(2, 4);
        this.color = `hsl(${random(0, 360)}, 100%, 50%)`;
        this.speed = random(1, 3);
        this.angle = random(0, Math.PI * 2);
        this.alpha = 1;
        this.decay = random(0.015, 0.03);
        this.particles = [];
        this.createParticles();
    }

    Firework.prototype.createParticles = function() {
        const numParticles = 50;
        for (let i = 0; i < numParticles; i++) {
            const angle = random(0, Math.PI * 2);
            const speed = random(1, 4);
            const radius = random(1, 2);
            const color = `hsl(${random(0, 360)}, 100%, 60%)`;
            this.particles.push(new Particle(this.x, this.y, angle, speed, radius, color));
        }
    };

    function Particle(x, y, angle, speed, radius, color) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.alpha = 1;
        this.decay = random(0.015, 0.02);
    }

    Particle.prototype.update = function() {
        this.x += Math.cos(this.angle) * this.speed;
        this.y += Math.sin(this.angle) * this.speed;
        this.alpha -= this.decay;
    };

    Particle.prototype.draw = function() {
        ctx.save();
        ctx.globalAlpha = this.alpha;
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
        ctx.fillStyle = this.color;
        ctx.fill();
        ctx.restore();
    };

    Firework.prototype.update = function () {
        this.particles.forEach(particle => {
            particle.update();
            particle.draw();
        });
        this.alpha -= this.decay;
    };

    Firework.prototype.draw = function () {
        // Không vẽ pháo hoa ban đầu nữa, chỉ vẽ hạt nhỏ
    };

    const fireworks = [];

    function animate() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        if (Math.random() < 0.05) {
            fireworks.push(new Firework(random(0, canvas.width), random(0, canvas.height)));
        }
        fireworks.forEach((firework, index) => {
            firework.update();
            if (firework.alpha <= 0) {
                fireworks.splice(index, 1);
            }
        });
        requestAnimationFrame(animate);
    }

    animate();
});

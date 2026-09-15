package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    public String home() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learn With Kastro | GitHub Actions + Kubernetes Masterclass</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * { 
            margin: 0; 
            padding: 0; 
            box-sizing: border-box; 
        }

        :root {
            --primary: #00ffcc;
            --secondary: #ffcc00;
            --accent: #6c8eff;
            --k8s-blue: #326ce5;
            --github-purple: #6e40c9;
            --youtube-red: #ff0000;
            --dark: #0b132b;
            --darker: #080f23;
            --light: #f0f8ff;
            --card-bg: rgba(28, 37, 65, 0.85);
            --transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            --gradient-1: linear-gradient(135deg, var(--primary), var(--accent));
            --gradient-2: linear-gradient(135deg, var(--secondary), #ff8800);
        }

        body {
            font-family: 'Segoe UI', system-ui, -apple-system, 'SF Pro Display', sans-serif;
            background: radial-gradient(ellipse at top, var(--darker) 0%, var(--dark) 70%);
            color: var(--light);
            line-height: 1.6;
            overflow-x: hidden;
            min-height: 100vh;
        }

        /* Hero Section */
        .hero {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
            padding: 80px 20px;
            position: relative;
            overflow: hidden;
        }

        .hero-bg {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -2;
            opacity: 0.4;
            background: 
                radial-gradient(circle at 20% 30%, rgba(50, 108, 229, 0.15) 0%, transparent 50%),
                radial-gradient(circle at 80% 70%, rgba(110, 64, 201, 0.15) 0%, transparent 50%);
        }

        .batch-announcement {
            font-size: 1.1rem;
            text-transform: uppercase;
            letter-spacing: 3px;
            color: var(--primary);
            margin-bottom: 15px;
            position: relative;
            display: inline-block;
            padding: 8px 20px;
            border: 1px solid rgba(0, 255, 204, 0.3);
            border-radius: 30px;
            background: rgba(0, 255, 204, 0.05);
            backdrop-filter: blur(5px);
            animation: blink 2s ease-in-out infinite;
        }

        @keyframes blink {
            0%, 100% { opacity: 1; }
            50% { opacity: 0.7; }
        }

        .title-container {
            margin-bottom: 30px;
            position: relative;
        }

        .main-icons {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 40px;
            margin-bottom: 40px;
        }

        .icon-wrapper {
            position: relative;
            width: 140px;
            height: 140px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .icon-orb {
            position: absolute;
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background: var(--card-bg);
            border: 2px solid;
            backdrop-filter: blur(10px);
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.5);
            transition: var(--transition);
        }

        .github-orb {
            border-color: var(--github-purple);
            animation: float 6s ease-in-out infinite;
        }

        .k8s-orb {
            border-color: var(--k8s-blue);
            animation: float 6s ease-in-out infinite reverse;
        }

        @keyframes float {
            0%, 100% { transform: translateY(0) rotate(0deg); }
            50% { transform: translateY(-20px) rotate(5deg); }
        }

        .icon-large {
            font-size: 5rem;
            position: relative;
            z-index: 2;
        }

        .github-icon-large {
            color: var(--github-purple);
            text-shadow: 0 0 30px rgba(110, 64, 201, 0.7);
        }

        .k8s-icon-large {
            color: var(--k8s-blue);
            text-shadow: 0 0 30px rgba(50, 108, 229, 0.7);
        }

        h1 {
            font-size: 4rem;
            background: linear-gradient(90deg, var(--primary), var(--accent), var(--primary));
            -webkit-background-clip: text;
            background-clip: text;
            color: transparent;
            background-size: 200% auto;
            animation: shimmer 3s ease-in-out infinite;
            margin: 0 0 20px 0;
            font-weight: 800;
            letter-spacing: -0.5px;
        }

        @keyframes shimmer {
            0% { background-position: 0% center; }
            50% { background-position: 100% center; }
            100% { background-position: 0% center; }
        }

        .hero-subtitle {
            font-size: 1.8rem;
            font-weight: 300;
            max-width: 800px;
            margin: 0 auto 40px;
            opacity: 0.9;
            line-height: 1.5;
        }

        /* Batch Start Date */
        .batch-date {
            margin: 40px 0;
            position: relative;
        }

        .date-card {
            background: linear-gradient(135deg, rgba(50, 108, 229, 0.2), rgba(110, 64, 201, 0.2));
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 25px;
            padding: 30px 50px;
            display: inline-flex;
            align-items: center;
            gap: 25px;
            backdrop-filter: blur(20px);
            box-shadow: 
                0 20px 60px rgba(0, 0, 0, 0.5),
                inset 0 1px 0 rgba(255, 255, 255, 0.1);
            transform-style: preserve-3d;
            perspective: 1000px;
            animation: pulse-glow 3s ease-in-out infinite;
        }

        @keyframes pulse-glow {
            0%, 100% { 
                box-shadow: 
                    0 20px 60px rgba(0, 0, 0, 0.5),
                    inset 0 1px 0 rgba(255, 255, 255, 0.1),
                    0 0 30px rgba(255, 204, 0, 0.3);
            }
            50% { 
                box-shadow: 
                    0 20px 60px rgba(0, 0, 0, 0.5),
                    inset 0 1px 0 rgba(255, 255, 255, 0.1),
                    0 0 60px rgba(255, 204, 0, 0.6);
            }
        }

        .date-icon {
            font-size: 3rem;
            color: var(--secondary);
        }

        .date-content {
            text-align: left;
        }

        .date-label {
            font-size: 1.2rem;
            opacity: 0.8;
            margin-bottom: 5px;
            display: block;
        }

        .date-main {
            font-size: 2.8rem;
            font-weight: 800;
            color: var(--secondary);
            line-height: 1;
            text-shadow: 0 0 20px rgba(255, 204, 0, 0.5);
        }

        /* Main Content */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
            position: relative;
        }

        .section {
            margin: 100px 0;
            opacity: 0;
            transform: translateY(50px);
            transition: all 0.8s cubic-bezier(0.4, 0, 0.2, 1);
        }

        .section.visible {
            opacity: 1;
            transform: translateY(0);
        }

        .section-title {
            text-align: center;
            font-size: 2.8rem;
            margin-bottom: 60px;
            position: relative;
            display: inline-block;
            left: 50%;
            transform: translateX(-50%);
        }

        .section-title:before {
            content: '';
            position: absolute;
            bottom: -15px;
            left: 50%;
            transform: translateX(-50%);
            width: 100px;
            height: 4px;
            background: var(--gradient-1);
            border-radius: 2px;
        }

        /* Stats */
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 30px;
            margin-top: 40px;
        }

        .stat-card {
            background: var(--card-bg);
            border-radius: 20px;
            padding: 40px 25px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.05);
            transition: var(--transition);
            position: relative;
            overflow: hidden;
            backdrop-filter: blur(10px);
        }

        .stat-card:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(135deg, transparent 30%, rgba(0, 255, 204, 0.05) 100%);
            z-index: -1;
        }

        .stat-card:hover {
            transform: translateY(-15px) scale(1.02);
            border-color: rgba(0, 255, 204, 0.3);
            box-shadow: 
                0 30px 60px rgba(0, 0, 0, 0.4),
                0 0 40px rgba(0, 255, 204, 0.1);
        }

        .stat-icon {
            font-size: 3rem;
            margin-bottom: 20px;
            color: var(--primary);
        }

        .stat-number {
            font-size: 3.5rem;
            font-weight: 800;
            background: var(--gradient-2);
            -webkit-background-clip: text;
            background-clip: text;
            color: transparent;
            margin: 15px 0;
            line-height: 1;
        }

        /* Cards */
        .cards-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
            gap: 40px;
            margin-top: 40px;
        }

        .card {
            background: var(--card-bg);
            border-radius: 25px;
            padding: 40px 35px;
            border: 1px solid rgba(255, 255, 255, 0.05);
            transition: var(--transition);
            position: relative;
            overflow: hidden;
            backdrop-filter: blur(10px);
        }

        .card:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 6px;
            height: 100%;
            background: var(--gradient-1);
        }

        .card:hover {
            transform: translateY(-15px);
            border-color: rgba(0, 255, 204, 0.2);
            box-shadow: 
                0 30px 60px rgba(0, 0, 0, 0.5),
                0 0 50px rgba(0, 255, 204, 0.1);
        }

        .card-header {
            display: flex;
            align-items: center;
            gap: 20px;
            margin-bottom: 30px;
        }

        .card-icon {
            font-size: 3rem;
            width: 80px;
            height: 80px;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 20px;
        }

        .github-card .card-icon {
            background: rgba(110, 64, 201, 0.15);
            color: var(--github-purple);
            animation: float 5s ease-in-out infinite;
        }

        .k8s-card .card-icon {
            background: rgba(50, 108, 229, 0.15);
            color: var(--k8s-blue);
            animation: float 5s ease-in-out infinite reverse;
        }

        .card h3 {
            font-size: 2rem;
            color: var(--primary);
            margin: 0;
        }

        .card ul {
            list-style: none;
            padding-left: 0;
        }

        .card li {
            padding: 15px 0;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            position: relative;
            padding-left: 35px;
            font-size: 1.1rem;
            transition: var(--transition);
        }

        .card li:before {
            content: '▸';
            position: absolute;
            left: 0;
            color: var(--secondary);
            font-weight: bold;
            font-size: 1.5rem;
            transition: var(--transition);
        }

        .card li:hover {
            color: var(--primary);
            padding-left: 40px;
        }

        .card li:hover:before {
            color: var(--primary);
            transform: translateX(5px);
        }

        .card li:last-child {
            border-bottom: none;
        }

        /* Audience Card */
        .audience-card {
            background: linear-gradient(135deg, rgba(50, 108, 229, 0.1), rgba(110, 64, 201, 0.1));
            border: 1px solid rgba(255, 255, 255, 0.1);
            max-width: 800px;
            margin: 0 auto;
        }

        /* CTA */
        .cta-section {
            text-align: center;
            margin: 120px 0;
            padding: 80px 40px;
            background: linear-gradient(135deg, rgba(28, 37, 65, 0.9), rgba(11, 19, 43, 0.9));
            border-radius: 30px;
            border: 1px solid rgba(0, 255, 204, 0.2);
            position: relative;
            overflow: hidden;
            backdrop-filter: blur(20px);
        }

        .cta-section:before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(0, 255, 204, 0.1) 0%, transparent 70%);
            z-index: -1;
            animation: rotate 20s linear infinite;
        }

        @keyframes rotate {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        .cta-button {
            display: inline-flex;
            align-items: center;
            gap: 20px;
            padding: 25px 60px;
            font-size: 1.5rem;
            font-weight: 700;
            background: var(--gradient-2);
            color: var(--darker);
            border-radius: 60px;
            text-decoration: none;
            box-shadow: 
                0 20px 50px rgba(255, 204, 0, 0.4),
                0 0 40px rgba(255, 204, 0, 0.3);
            transition: var(--transition);
            margin-top: 40px;
            position: relative;
            overflow: hidden;
            z-index: 1;
        }

        .cta-button:before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.3), transparent);
            transition: left 0.7s;
            z-index: -1;
        }

        .cta-button:hover:before {
            left: 100%;
        }

        .cta-button:hover {
            transform: scale(1.05);
            box-shadow: 
                0 30px 70px rgba(255, 204, 0, 0.6),
                0 0 60px rgba(255, 204, 0, 0.5);
        }

        /* QR Section */
        .qr-section {
            text-align: center;
            margin: 80px 0;
            padding: 50px 40px;
            background: rgba(11, 19, 43, 0.6);
            border-radius: 25px;
            border: 1px solid rgba(0, 255, 204, 0.1);
            backdrop-filter: blur(10px);
        }

        .qr-text {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 15px;
            font-size: 1.3rem;
            margin-bottom: 30px;
            color: var(--primary);
        }

        .qr-container {
            display: inline-block;
            padding: 30px;
            background: white;
            border-radius: 20px;
            box-shadow: 
                0 20px 50px rgba(0, 0, 0, 0.4),
                0 0 40px rgba(0, 255, 204, 0.2);
            transition: var(--transition);
        }

        .qr-container:hover {
            transform: translateY(-10px) scale(1.05);
        }

        /* Footer */
        footer {
            text-align: center;
            padding: 80px 20px 40px;
            margin-top: 100px;
            background: linear-gradient(to top, rgba(8, 15, 35, 0.95), transparent);
            border-top: 1px solid rgba(0, 255, 204, 0.1);
            position: relative;
        }

        footer:before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 1px;
            background: linear-gradient(90deg, transparent, var(--primary), transparent);
        }

        .footer-links {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 30px;
            max-width: 1000px;
            margin: 0 auto 50px;
        }

        .contact-card {
            background: var(--card-bg);
            padding: 30px 20px;
            border-radius: 20px;
            border: 1px solid rgba(255, 255, 255, 0.05);
            transition: var(--transition);
            backdrop-filter: blur(10px);
        }

        .contact-card:hover {
            transform: translateY(-10px);
            border-color: rgba(0, 255, 204, 0.2);
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
        }

        .youtube-card:hover {
            border-color: rgba(255, 0, 0, 0.3);
            box-shadow: 0 20px 40px rgba(255, 0, 0, 0.2);
        }

        .contact-icon {
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        .email-icon {
            color: var(--primary);
        }

        .phone-icon {
            color: var(--secondary);
        }

        .website-icon {
            color: var(--accent);
        }

        .youtube-icon {
            color: var(--youtube-red);
        }

        .contact-title {
            font-size: 1.3rem;
            margin-bottom: 15px;
            color: var(--light);
            font-weight: 600;
        }

        .contact-info {
            font-size: 1rem;
            opacity: 0.9;
            line-height: 1.5;
        }

        .contact-link {
            color: var(--primary);
            text-decoration: none;
            transition: var(--transition);
            word-break: break-word;
        }

        .contact-link:hover {
            color: var(--secondary);
            text-decoration: underline;
        }

        .youtube-link:hover {
            color: var(--youtube-red);
        }

        .copyright {
            opacity: 0.7;
            font-size: 0.9rem;
            margin-top: 50px;
            padding-top: 30px;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
        }

        /* Responsive */
        @media (max-width: 992px) {
            h1 { font-size: 3rem; }
            .hero-subtitle { font-size: 1.5rem; }
            .main-icons { gap: 20px; }
            .icon-wrapper { width: 100px; height: 100px; }
            .icon-large { font-size: 3.5rem; }
            .date-main { font-size: 2.2rem; }
            .cards-grid { grid-template-columns: 1fr; }
            .footer-links { grid-template-columns: repeat(2, 1fr); }
        }

        @media (max-width: 768px) {
            h1 { font-size: 2.5rem; }
            .hero { padding: 60px 20px; }
            .icon-wrapper { width: 80px; height: 80px; }
            .icon-large { font-size: 2.8rem; }
            .date-card { padding: 20px 30px; flex-direction: column; text-align: center; }
            .date-main { font-size: 2rem; }
            .section-title { font-size: 2.2rem; }
            .cta-button { padding: 20px 40px; font-size: 1.3rem; }
            .stat-number { font-size: 2.8rem; }
            .footer-links { grid-template-columns: 1fr; }
            .batch-announcement { font-size: 0.9rem; letter-spacing: 2px; padding: 6px 15px; }
        }
    </style>
</head>
<body>
    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-bg"></div>
        
        <!-- Announcement Badge -->
        <div class="batch-announcement">
            🎉 Announcing New Batch On
        </div>
        
        <div class="main-icons">
            <div class="icon-wrapper">
                <div class="icon-orb github-orb"></div>
                <i class="fab fa-github-alt icon-large github-icon-large"></i>
            </div>
            <div class="icon-wrapper">
                <div class="icon-orb k8s-orb"></div>
                <i class="fab fa-docker icon-large k8s-icon-large"></i>
            </div>
        </div>
        
        <div class="title-container">
            <h1>GitHub Actions + Kubernetes</h1>
        </div>
        
        <p class="hero-subtitle">
            Master Industry-Grade CI/CD Pipelines & Cloud-Native Deployments
        </p>

        <!-- Batch Start Date -->
        <div class="batch-date">
            <div class="date-card">
                <div class="date-icon">
                    <i class="fas fa-calendar-star"></i>
                </div>
                <div class="date-content">
                    <span class="date-label">🚀 Training Starts From</span>
                    <div class="date-main">29 January 2026</div>
                </div>
            </div>
        </div>
    </section>

    <div class="container">
        <!-- Training Highlights -->
        <section class="section" id="highlights">
            <h2 class="section-title">⭐ Training Highlights</h2>
            <div class="stats-grid">
                <div class="stat-card">
                    <div class="stat-icon"><i class="fas fa-calendar-check"></i></div>
                    <div class="stat-number">35-40</div>
                    <p>Days Live Training</p>
                </div>
                <div class="stat-card">
                    <div class="stat-icon"><i class="fas fa-tools"></i></div>
                    <div class="stat-number">5+</div>
                    <p>Major Tools Covered</p>
                </div>
                <div class="stat-card">
                    <div class="stat-icon"><i class="fas fa-project-diagram"></i></div>
                    <div class="stat-number">5</div>
                    <p>Hands-on Projects</p>
                </div>
                <div class="stat-card">
                    <div class="stat-icon"><i class="fas fa-trophy"></i></div>
                    <div class="stat-number">2</div>
                    <p>Capstone Projects</p>
                </div>
            </div>
        </section>

        <!-- Curriculum -->
        <section class="section" id="curriculum">
            <h2 class="section-title">📚 Curriculum Overview</h2>
            <div class="cards-grid">
                <div class="card github-card">
                    <div class="card-header">
                        <div class="card-icon">
                            <i class="fab fa-github"></i>
                        </div>
                        <h3>GitHub Actions Mastery</h3>
                    </div>
                    <ul>
                        <li>Complete CI/CD Pipeline Design</li>
                        <li>Hosted & Self-Hosted Runners</li>
                        <li>Advanced Security & Secrets Management</li>
                        <li>Docker Image Build & Push Pipelines</li>
                        <li>Multi-Stage & Matrix Workflows</li>
                        <li>Automated Versioning & Releases</li>
                        <li>Custom GitHub Actions Development</li>
                        <li>Enterprise Best Practices</li>
                    </ul>
                </div>
                
                <div class="card k8s-card">
                    <div class="card-header">
                        <div class="card-icon">
                            <i class="fab fa-docker"></i>
                        </div>
                        <h3>Kubernetes Mastery</h3>
                    </div>
                    <ul>
                        <li>Kubernetes Architecture Deep Dive</li>
                        <li>Pods, Deployments & Services</li>
                        <li>Advanced Networking & Ingress</li>
                        <li>Helm Charts & Package Management</li>
                        <li>AWS EKS Deployment & Management</li>
                        <li>GitOps with ArgoCD</li>
                        <li>Monitoring with Prometheus & Grafana</li>
                        <li>Service Mesh with Istio</li>
                        <li>Production Security & RBAC</li>
                    </ul>
                </div>
            </div>
        </section>

        <!-- Audience -->
        <section class="section" id="audience">
            <h2 class="section-title">🎯 Perfect For</h2>
            <div class="card audience-card">
                <div class="card-header">
                    <div class="card-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <h3>Who Should Join This Training?</h3>
                </div>
                <ul>
                    <li><span class="highlight">DevOps Engineers</span> looking to master cloud-native technologies</li>
                    <li><span class="highlight">Software Developers</span> transitioning to DevOps roles</li>
                    <li><span class="highlight">System Administrators</span> upgrading to container orchestration</li>
                    <li><span class="highlight">Cloud Engineers</span> specializing in Kubernetes</li>
                    <li><span class="highlight">Freshers & Students</span> aiming for high-growth DevOps careers</li>
                    <li><span class="highlight">IT Professionals</span> preparing for production deployments</li>
                </ul>
            </div>
        </section>

        <!-- CTA -->
        <section class="cta-section">
            <h2 style="font-size: 3rem; margin-bottom: 30px; color: var(--secondary);">
                🚀 Ready to Accelerate Your Career?
            </h2>
            <p style="font-size: 1.4rem; max-width: 800px; margin: 0 auto 40px; opacity: 0.95; line-height: 1.6;">
                Join the most comprehensive GitHub Actions & Kubernetes training program. 
                Transform your skills with hands-on projects and industry-relevant curriculum.
            </p>
            <a href="https://forms.gle/D5dib9DFsfSN4Koy7" target="_blank" class="cta-button">
                <i class="fas fa-rocket"></i>
                Reserve Your Seat Now
            </a>
        </section>

        <!-- QR -->
        <section class="qr-section">
            <div class="qr-text">
                <i class="fas fa-qrcode"></i>
                <span>Scan to Register Instantly</span>
            </div>
            <div class="qr-container">
                <img src="https://api.qrserver.com/v1/create-qr-code/?size=220x220&data=https://forms.gle/D5dib9DFsfSN4Koy7&format=svg&color=0b132b&bgcolor=ffffff&qzone=2" 
                     alt="Registration QR Code"
                     style="width: 220px; height: 220px;">
            </div>
        </section>
    </div>

    <footer>
        <div class="footer-links">
            <div class="contact-card">
                <div class="contact-icon email-icon">
                    <i class="fas fa-envelope"></i>
                </div>
                <div class="contact-title">Email Us</div>
                <div class="contact-info">
                    <a href="mailto:learnwithkastro@gmail.com" class="contact-link">
                        learnwithkastro@gmail.com
                    </a>
                </div>
            </div>
            
            <div class="contact-card">
                <div class="contact-icon phone-icon">
                    <i class="fas fa-phone"></i>
                </div>
                <div class="contact-title">Call Us</div>
                <div class="contact-info">
                    <a href="tel:+919700712459" class="contact-link">
                        +91 97007 12459
                    </a>
                </div>
            </div>
            
            <div class="contact-card">
                <div class="contact-icon website-icon">
                    <i class="fas fa-globe"></i>
                </div>
                <div class="contact-title">Website</div>
                <div class="contact-info">
                    <a href="https://www.learnwithkastro.com" target="_blank" class="contact-link">
                        www.learnwithkastro.com
                    </a>
                </div>
            </div>
            
            <div class="contact-card youtube-card">
                <div class="contact-icon youtube-icon">
                    <i class="fab fa-youtube"></i>
                </div>
                <div class="contact-title">YouTube Channel</div>
                <div class="contact-info">
                    <a href="https://www.youtube.com/@LearnWithKASTRO" target="_blank" class="contact-link youtube-link">
                        @LearnWithKASTRO
                    </a>
                    <div style="margin-top: 10px; font-size: 0.9rem; opacity: 0.8;">
                        Watch tutorials & demos
                    </div>
                </div>
            </div>
        </div>
        
        <div class="copyright">
            <p>© 2026 Learn With Kastro. All rights reserved.</p>
            <p style="margin-top: 10px; font-size: 0.95rem;">
                Transform Your DevOps Career with Expert-Led Training
            </p>
        </div>
    </footer>

    <script>
        // Scroll animations
        document.addEventListener('DOMContentLoaded', function() {
            const sections = document.querySelectorAll('.section');
            
            const observer = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.classList.add('visible');
                    }
                });
            }, {
                threshold: 0.1,
                rootMargin: '0px 0px -100px 0px'
            });
            
            sections.forEach(section => {
                observer.observe(section);
            });

            // Create floating particles
            const heroBg = document.querySelector('.hero-bg');
            for (let i = 0; i < 15; i++) {
                const particle = document.createElement('div');
                particle.style.position = 'absolute';
                particle.style.width = Math.random() * 5 + 2 + 'px';
                particle.style.height = particle.style.width;
                particle.style.background = Math.random() > 0.5 ? 'rgba(0, 255, 204, 0.2)' : 'rgba(255, 204, 0, 0.2)';
                particle.style.borderRadius = '50%';
                particle.style.left = Math.random() * 100 + '%';
                particle.style.top = Math.random() * 100 + '%';
                particle.style.animation = `float ${Math.random() * 10 + 10}s ease-in-out infinite`;
                particle.style.animationDelay = Math.random() * 5 + 's';
                heroBg.appendChild(particle);
            }
        });
    </script>
</body>
</html>
        """;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

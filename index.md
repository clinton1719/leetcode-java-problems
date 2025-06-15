---
layout: default
title: Home
---

# LeetCode Java Solutions

Welcome! Browse problems by tag or directly here:

## Tags
<ul>
  {% for tag in site.tags %}
    <li><a href="{{ site.baseurl }}/tags/{{ tag[0] }}">{{ tag[0] }} ({{ tag[1].size }})</a></li>
  {% endfor %}
</ul>

## All Problems
<ul>
  {% for page in site.pages %}
    {% if page.path contains 'problems/' %}
      <li><a href="{{ page.url }}">{{ page.title }}</a></li>
    {% endif %}
  {% endfor %}
</ul>

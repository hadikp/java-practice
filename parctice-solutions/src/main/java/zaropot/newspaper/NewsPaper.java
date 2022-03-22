package zaropot.newspaper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NewsPaper {

    private String name;
    private Set<Article> articles = new HashSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> findArticlesByAuthor(String author) {
        return articles.stream().filter(f -> f.getAuthor().equals(author)).toList();
    }

    public List<Article> findArticleByParagraphPart(String word) {
        return articles.stream().filter(f -> f.getParagraphs().equals(word)).toList();
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return new TreeSet<>(articles);
    }
}

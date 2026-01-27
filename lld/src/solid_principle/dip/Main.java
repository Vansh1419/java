package solid_principle.dip;

interface RecommendationStrategy{
    void recommend();
}

class TrendingRecommendation implements RecommendationStrategy{
    public void recommend(){

    }
}
class GenreRecommendation implements RecommendationStrategy{
    public void recommend(){

    }
}
class RecentRecommendation implements RecommendationStrategy{
    public void recommend(){

    }
}

class RecommendationAlgorithm{
    private RecommendationStrategy recommendationStrategy;

    public RecommendationAlgorithm(RecommendationStrategy recommendationStrategy) {
        this.recommendationStrategy = recommendationStrategy;
    }

    public void recommend(){
        recommendationStrategy.recommend();
    }
}
public class Main {
    public static void main(String[] args) {
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new TrendingRecommendation());
        recommendationAlgorithm.recommend();
    }
}

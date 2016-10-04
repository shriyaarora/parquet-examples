package netflix.example;

/**
 * Created by sarora on 6/1/16.
 */
import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

 class PopularityData {
    private  String show_title_id;
    private  String language;
    private  Double view_minutes;
    private  Integer view_count;
    private  Double percent_vote_view_fractions;
    private  Double norm_max_title_view_fractions;

    public PopularityData(){};

    PopularityData(
             String videoID,
             String language,
             Double viewMinutesInDay,
             Integer ViewCountInDay,
             Double percentOfVoteByViewFractionsInDay,
             Double normalizedMaxEpisodeFractionalPlaysInDay
    ) {
        this.show_title_id = videoID;
        this.language = checkNotNull(language, "language");
        this.view_minutes = checkNotNull(viewMinutesInDay, "view_minutes");
        this.view_count = checkNotNull(ViewCountInDay, "view_count");
        this.percent_vote_view_fractions = checkNotNull(percentOfVoteByViewFractionsInDay, "percent_vote_view_fractions");
        this.norm_max_title_view_fractions = checkNotNull(normalizedMaxEpisodeFractionalPlaysInDay, "norm_max_title_view_fractions");
    }

    public String getShow_title_id() {
        return show_title_id;
    }

    public String getLanguage() {
        return language;
    }

    public Double getView_minutes() {
        return view_minutes;
    }

    public Integer getView_count() {
        return view_count;
    }

    public Double getPercent_vote_view_fractions() {
        return percent_vote_view_fractions;
    }

    public Double getNorm_max_title_view_fractions() {
        return norm_max_title_view_fractions;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("show_title_id", show_title_id)
                .add("language", language)
                .add("view_minutes", view_minutes)
                .add("view_count",view_count)
                .add("percent_vote_view_fractions",percent_vote_view_fractions)
                .add("norm_max_title_view_fractions",norm_max_title_view_fractions)
                .toString();
    }
}
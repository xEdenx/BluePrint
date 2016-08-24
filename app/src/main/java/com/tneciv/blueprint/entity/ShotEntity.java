package com.tneciv.blueprint.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-15 18:17 .
 */
public class ShotEntity implements Parcelable {

    /**
     * id : 2916467
     * title : BOLD icons
     * description : <p>More visual exploration for the upcoming BOLD landingpage. 2x for full view.</p>
     * width : 400
     * height : 300
     * images : {"hidpi":"https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold.png","normal":"https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold_1x.png","teaser":"https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold_teaser.png"}
     * views_count : 1198
     * likes_count : 80
     * comments_count : 2
     * attachments_count : 0
     * rebounds_count : 0
     * buckets_count : 1
     * created_at : 2016-08-23T07:31:34Z
     * updated_at : 2016-08-23T15:04:32Z
     * html_url : https://dribbble.com/shots/2916467-BOLD-icons
     * attachments_url : https://api.dribbble.com/v1/shots/2916467/attachments
     * buckets_url : https://api.dribbble.com/v1/shots/2916467/buckets
     * comments_url : https://api.dribbble.com/v1/shots/2916467/comments
     * likes_url : https://api.dribbble.com/v1/shots/2916467/likes
     * projects_url : https://api.dribbble.com/v1/shots/2916467/projects
     * rebounds_url : https://api.dribbble.com/v1/shots/2916467/rebounds
     * animated : false
     * tags : ["bold","corporate","icons","iconset","illustration","logo","pattern","vector"]
     * user : {"id":78594,"name":"Jonas","username":"jonassoeder","html_url":"https://dribbble.com/jonassoeder","avatar_url":"https://d13yacurqjgara.cloudfront.net/users/78594/avatars/normal/62aaf21908d793e27c5c57ab1600b4b0.png?1425409078","bio":"","location":"Berlin","links":{"twitter":"https://twitter.com/jonassoeder"},"buckets_count":3,"comments_received_count":3005,"followers_count":12743,"followings_count":992,"likes_count":59081,"likes_received_count":54918,"projects_count":7,"rebounds_received_count":48,"shots_count":196,"teams_count":1,"can_upload_shot":true,"type":"Player","pro":false,"buckets_url":"https://api.dribbble.com/v1/users/78594/buckets","followers_url":"https://api.dribbble.com/v1/users/78594/followers","following_url":"https://api.dribbble.com/v1/users/78594/following","likes_url":"https://api.dribbble.com/v1/users/78594/likes","projects_url":"https://api.dribbble.com/v1/users/78594/projects","shots_url":"https://api.dribbble.com/v1/users/78594/shots","teams_url":"https://api.dribbble.com/v1/users/78594/teams","created_at":"2011-11-25T09:39:38Z","updated_at":"2016-08-23T15:04:32Z"}
     * team : {"id":828269,"name":"FCKN BOLD","username":"fcknbold","html_url":"https://dribbble.com/fcknbold","avatar_url":"https://d13yacurqjgara.cloudfront.net/users/828269/avatars/normal/974c65ebdaea8961587d2d0a524dc001.png?1470310320","bio":"People. Design. Product. That&#39;s it.","location":"Berlin, Germany","links":{"twitter":"https://twitter.com/fcknbold"},"buckets_count":0,"comments_received_count":0,"followers_count":127,"followings_count":4,"likes_count":5,"likes_received_count":0,"projects_count":0,"rebounds_received_count":0,"shots_count":8,"can_upload_shot":true,"type":"Team","pro":false,"buckets_url":"https://api.dribbble.com/v1/users/828269/buckets","followers_url":"https://api.dribbble.com/v1/users/828269/followers","following_url":"https://api.dribbble.com/v1/users/828269/following","likes_url":"https://api.dribbble.com/v1/users/828269/likes","projects_url":"https://api.dribbble.com/v1/users/828269/projects","shots_url":"https://api.dribbble.com/v1/users/828269/shots","created_at":"2015-04-24T09:52:38Z","updated_at":"2016-08-23T15:07:33Z","members_count":6,"members_url":"https://api.dribbble.com/v1/teams/828269/members","team_shots_url":"https://api.dribbble.com/v1/teams/828269/shots"}
     */

    private int id;
    private String title;
    private String description;
    private int width;
    private int height;
    /**
     * hidpi : https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold.png
     * normal : https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold_1x.png
     * teaser : https://d13yacurqjgara.cloudfront.net/users/78594/screenshots/2916467/bold_teaser.png
     */

    private ImagesBean images;
    private int views_count;
    private int likes_count;
    private int comments_count;
    private int attachments_count;
    private int rebounds_count;
    private int buckets_count;
    private String created_at;
    private String updated_at;
    private String html_url;
    private String attachments_url;
    private String buckets_url;
    private String comments_url;
    private String likes_url;
    private String projects_url;
    private String rebounds_url;
    private boolean animated;
    /**
     * id : 78594
     * name : Jonas
     * username : jonassoeder
     * html_url : https://dribbble.com/jonassoeder
     * avatar_url : https://d13yacurqjgara.cloudfront.net/users/78594/avatars/normal/62aaf21908d793e27c5c57ab1600b4b0.png?1425409078
     * bio :
     * location : Berlin
     * links : {"twitter":"https://twitter.com/jonassoeder"}
     * buckets_count : 3
     * comments_received_count : 3005
     * followers_count : 12743
     * followings_count : 992
     * likes_count : 59081
     * likes_received_count : 54918
     * projects_count : 7
     * rebounds_received_count : 48
     * shots_count : 196
     * teams_count : 1
     * can_upload_shot : true
     * type : Player
     * pro : false
     * buckets_url : https://api.dribbble.com/v1/users/78594/buckets
     * followers_url : https://api.dribbble.com/v1/users/78594/followers
     * following_url : https://api.dribbble.com/v1/users/78594/following
     * likes_url : https://api.dribbble.com/v1/users/78594/likes
     * projects_url : https://api.dribbble.com/v1/users/78594/projects
     * shots_url : https://api.dribbble.com/v1/users/78594/shots
     * teams_url : https://api.dribbble.com/v1/users/78594/teams
     * created_at : 2011-11-25T09:39:38Z
     * updated_at : 2016-08-23T15:04:32Z
     */

    private UserBean user;
    /**
     * id : 828269
     * name : FCKN BOLD
     * username : fcknbold
     * html_url : https://dribbble.com/fcknbold
     * avatar_url : https://d13yacurqjgara.cloudfront.net/users/828269/avatars/normal/974c65ebdaea8961587d2d0a524dc001.png?1470310320
     * bio : People. Design. Product. That&#39;s it.
     * location : Berlin, Germany
     * links : {"twitter":"https://twitter.com/fcknbold"}
     * buckets_count : 0
     * comments_received_count : 0
     * followers_count : 127
     * followings_count : 4
     * likes_count : 5
     * likes_received_count : 0
     * projects_count : 0
     * rebounds_received_count : 0
     * shots_count : 8
     * can_upload_shot : true
     * type : Team
     * pro : false
     * buckets_url : https://api.dribbble.com/v1/users/828269/buckets
     * followers_url : https://api.dribbble.com/v1/users/828269/followers
     * following_url : https://api.dribbble.com/v1/users/828269/following
     * likes_url : https://api.dribbble.com/v1/users/828269/likes
     * projects_url : https://api.dribbble.com/v1/users/828269/projects
     * shots_url : https://api.dribbble.com/v1/users/828269/shots
     * created_at : 2015-04-24T09:52:38Z
     * updated_at : 2016-08-23T15:07:33Z
     * members_count : 6
     * members_url : https://api.dribbble.com/v1/teams/828269/members
     * team_shots_url : https://api.dribbble.com/v1/teams/828269/shots
     */

    private TeamBean team;
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getAttachments_count() {
        return attachments_count;
    }

    public void setAttachments_count(int attachments_count) {
        this.attachments_count = attachments_count;
    }

    public int getRebounds_count() {
        return rebounds_count;
    }

    public void setRebounds_count(int rebounds_count) {
        this.rebounds_count = rebounds_count;
    }

    public int getBuckets_count() {
        return buckets_count;
    }

    public void setBuckets_count(int buckets_count) {
        this.buckets_count = buckets_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getAttachments_url() {
        return attachments_url;
    }

    public void setAttachments_url(String attachments_url) {
        this.attachments_url = attachments_url;
    }

    public String getBuckets_url() {
        return buckets_url;
    }

    public void setBuckets_url(String buckets_url) {
        this.buckets_url = buckets_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getLikes_url() {
        return likes_url;
    }

    public void setLikes_url(String likes_url) {
        this.likes_url = likes_url;
    }

    public String getProjects_url() {
        return projects_url;
    }

    public void setProjects_url(String projects_url) {
        this.projects_url = projects_url;
    }

    public String getRebounds_url() {
        return rebounds_url;
    }

    public void setRebounds_url(String rebounds_url) {
        this.rebounds_url = rebounds_url;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public TeamBean getTeam() {
        return team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class ImagesBean implements Parcelable {
        private String hidpi;
        private String normal;
        private String teaser;

        public String getHidpi() {
            return hidpi;
        }

        public void setHidpi(String hidpi) {
            this.hidpi = hidpi;
        }

        public String getNormal() {
            return normal;
        }

        public void setNormal(String normal) {
            this.normal = normal;
        }

        public String getTeaser() {
            return teaser;
        }

        public void setTeaser(String teaser) {
            this.teaser = teaser;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.hidpi);
            dest.writeString(this.normal);
            dest.writeString(this.teaser);
        }

        public ImagesBean() {
        }

        protected ImagesBean(Parcel in) {
            this.hidpi = in.readString();
            this.normal = in.readString();
            this.teaser = in.readString();
        }

        public static final Creator<ImagesBean> CREATOR = new Creator<ImagesBean>() {
            @Override
            public ImagesBean createFromParcel(Parcel source) {
                return new ImagesBean(source);
            }

            @Override
            public ImagesBean[] newArray(int size) {
                return new ImagesBean[size];
            }
        };
    }

    public static class UserBean implements Parcelable {
        private int id;
        private String name;
        private String username;
        private String html_url;
        private String avatar_url;
        private String bio;
        private String location;
        /**
         * twitter : https://twitter.com/jonassoeder
         */

        private LinksBean links;
        private int buckets_count;
        private int comments_received_count;
        private int followers_count;
        private int followings_count;
        private int likes_count;
        private int likes_received_count;
        private int projects_count;
        private int rebounds_received_count;
        private int shots_count;
        private int teams_count;
        private boolean can_upload_shot;
        private String type;
        private boolean pro;
        private String buckets_url;
        private String followers_url;
        private String following_url;
        private String likes_url;
        private String projects_url;
        private String shots_url;
        private String teams_url;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(LinksBean links) {
            this.links = links;
        }

        public int getBuckets_count() {
            return buckets_count;
        }

        public void setBuckets_count(int buckets_count) {
            this.buckets_count = buckets_count;
        }

        public int getComments_received_count() {
            return comments_received_count;
        }

        public void setComments_received_count(int comments_received_count) {
            this.comments_received_count = comments_received_count;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(int followings_count) {
            this.followings_count = followings_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public int getLikes_received_count() {
            return likes_received_count;
        }

        public void setLikes_received_count(int likes_received_count) {
            this.likes_received_count = likes_received_count;
        }

        public int getProjects_count() {
            return projects_count;
        }

        public void setProjects_count(int projects_count) {
            this.projects_count = projects_count;
        }

        public int getRebounds_received_count() {
            return rebounds_received_count;
        }

        public void setRebounds_received_count(int rebounds_received_count) {
            this.rebounds_received_count = rebounds_received_count;
        }

        public int getShots_count() {
            return shots_count;
        }

        public void setShots_count(int shots_count) {
            this.shots_count = shots_count;
        }

        public int getTeams_count() {
            return teams_count;
        }

        public void setTeams_count(int teams_count) {
            this.teams_count = teams_count;
        }

        public boolean isCan_upload_shot() {
            return can_upload_shot;
        }

        public void setCan_upload_shot(boolean can_upload_shot) {
            this.can_upload_shot = can_upload_shot;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isPro() {
            return pro;
        }

        public void setPro(boolean pro) {
            this.pro = pro;
        }

        public String getBuckets_url() {
            return buckets_url;
        }

        public void setBuckets_url(String buckets_url) {
            this.buckets_url = buckets_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getLikes_url() {
            return likes_url;
        }

        public void setLikes_url(String likes_url) {
            this.likes_url = likes_url;
        }

        public String getProjects_url() {
            return projects_url;
        }

        public void setProjects_url(String projects_url) {
            this.projects_url = projects_url;
        }

        public String getShots_url() {
            return shots_url;
        }

        public void setShots_url(String shots_url) {
            this.shots_url = shots_url;
        }

        public String getTeams_url() {
            return teams_url;
        }

        public void setTeams_url(String teams_url) {
            this.teams_url = teams_url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class LinksBean implements Parcelable {
            private String twitter;

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.twitter);
            }

            public LinksBean() {
            }

            protected LinksBean(Parcel in) {
                this.twitter = in.readString();
            }

            public static final Creator<LinksBean> CREATOR = new Creator<LinksBean>() {
                @Override
                public LinksBean createFromParcel(Parcel source) {
                    return new LinksBean(source);
                }

                @Override
                public LinksBean[] newArray(int size) {
                    return new LinksBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.username);
            dest.writeString(this.html_url);
            dest.writeString(this.avatar_url);
            dest.writeString(this.bio);
            dest.writeString(this.location);
            dest.writeParcelable(this.links, flags);
            dest.writeInt(this.buckets_count);
            dest.writeInt(this.comments_received_count);
            dest.writeInt(this.followers_count);
            dest.writeInt(this.followings_count);
            dest.writeInt(this.likes_count);
            dest.writeInt(this.likes_received_count);
            dest.writeInt(this.projects_count);
            dest.writeInt(this.rebounds_received_count);
            dest.writeInt(this.shots_count);
            dest.writeInt(this.teams_count);
            dest.writeByte(this.can_upload_shot ? (byte) 1 : (byte) 0);
            dest.writeString(this.type);
            dest.writeByte(this.pro ? (byte) 1 : (byte) 0);
            dest.writeString(this.buckets_url);
            dest.writeString(this.followers_url);
            dest.writeString(this.following_url);
            dest.writeString(this.likes_url);
            dest.writeString(this.projects_url);
            dest.writeString(this.shots_url);
            dest.writeString(this.teams_url);
            dest.writeString(this.created_at);
            dest.writeString(this.updated_at);
        }

        public UserBean() {
        }

        protected UserBean(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.username = in.readString();
            this.html_url = in.readString();
            this.avatar_url = in.readString();
            this.bio = in.readString();
            this.location = in.readString();
            this.links = in.readParcelable(LinksBean.class.getClassLoader());
            this.buckets_count = in.readInt();
            this.comments_received_count = in.readInt();
            this.followers_count = in.readInt();
            this.followings_count = in.readInt();
            this.likes_count = in.readInt();
            this.likes_received_count = in.readInt();
            this.projects_count = in.readInt();
            this.rebounds_received_count = in.readInt();
            this.shots_count = in.readInt();
            this.teams_count = in.readInt();
            this.can_upload_shot = in.readByte() != 0;
            this.type = in.readString();
            this.pro = in.readByte() != 0;
            this.buckets_url = in.readString();
            this.followers_url = in.readString();
            this.following_url = in.readString();
            this.likes_url = in.readString();
            this.projects_url = in.readString();
            this.shots_url = in.readString();
            this.teams_url = in.readString();
            this.created_at = in.readString();
            this.updated_at = in.readString();
        }

        public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
            @Override
            public UserBean createFromParcel(Parcel source) {
                return new UserBean(source);
            }

            @Override
            public UserBean[] newArray(int size) {
                return new UserBean[size];
            }
        };
    }

    public static class TeamBean implements Parcelable {
        private int id;
        private String name;
        private String username;
        private String html_url;
        private String avatar_url;
        private String bio;
        private String location;
        /**
         * twitter : https://twitter.com/fcknbold
         */

        private LinksBean links;
        private int buckets_count;
        private int comments_received_count;
        private int followers_count;
        private int followings_count;
        private int likes_count;
        private int likes_received_count;
        private int projects_count;
        private int rebounds_received_count;
        private int shots_count;
        private boolean can_upload_shot;
        private String type;
        private boolean pro;
        private String buckets_url;
        private String followers_url;
        private String following_url;
        private String likes_url;
        private String projects_url;
        private String shots_url;
        private String created_at;
        private String updated_at;
        private int members_count;
        private String members_url;
        private String team_shots_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(LinksBean links) {
            this.links = links;
        }

        public int getBuckets_count() {
            return buckets_count;
        }

        public void setBuckets_count(int buckets_count) {
            this.buckets_count = buckets_count;
        }

        public int getComments_received_count() {
            return comments_received_count;
        }

        public void setComments_received_count(int comments_received_count) {
            this.comments_received_count = comments_received_count;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(int followings_count) {
            this.followings_count = followings_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public int getLikes_received_count() {
            return likes_received_count;
        }

        public void setLikes_received_count(int likes_received_count) {
            this.likes_received_count = likes_received_count;
        }

        public int getProjects_count() {
            return projects_count;
        }

        public void setProjects_count(int projects_count) {
            this.projects_count = projects_count;
        }

        public int getRebounds_received_count() {
            return rebounds_received_count;
        }

        public void setRebounds_received_count(int rebounds_received_count) {
            this.rebounds_received_count = rebounds_received_count;
        }

        public int getShots_count() {
            return shots_count;
        }

        public void setShots_count(int shots_count) {
            this.shots_count = shots_count;
        }

        public boolean isCan_upload_shot() {
            return can_upload_shot;
        }

        public void setCan_upload_shot(boolean can_upload_shot) {
            this.can_upload_shot = can_upload_shot;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isPro() {
            return pro;
        }

        public void setPro(boolean pro) {
            this.pro = pro;
        }

        public String getBuckets_url() {
            return buckets_url;
        }

        public void setBuckets_url(String buckets_url) {
            this.buckets_url = buckets_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getLikes_url() {
            return likes_url;
        }

        public void setLikes_url(String likes_url) {
            this.likes_url = likes_url;
        }

        public String getProjects_url() {
            return projects_url;
        }

        public void setProjects_url(String projects_url) {
            this.projects_url = projects_url;
        }

        public String getShots_url() {
            return shots_url;
        }

        public void setShots_url(String shots_url) {
            this.shots_url = shots_url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getMembers_count() {
            return members_count;
        }

        public void setMembers_count(int members_count) {
            this.members_count = members_count;
        }

        public String getMembers_url() {
            return members_url;
        }

        public void setMembers_url(String members_url) {
            this.members_url = members_url;
        }

        public String getTeam_shots_url() {
            return team_shots_url;
        }

        public void setTeam_shots_url(String team_shots_url) {
            this.team_shots_url = team_shots_url;
        }

        public static class LinksBean implements Parcelable {
            private String twitter;

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.twitter);
            }

            public LinksBean() {
            }

            protected LinksBean(Parcel in) {
                this.twitter = in.readString();
            }

            public static final Creator<LinksBean> CREATOR = new Creator<LinksBean>() {
                @Override
                public LinksBean createFromParcel(Parcel source) {
                    return new LinksBean(source);
                }

                @Override
                public LinksBean[] newArray(int size) {
                    return new LinksBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.username);
            dest.writeString(this.html_url);
            dest.writeString(this.avatar_url);
            dest.writeString(this.bio);
            dest.writeString(this.location);
            dest.writeParcelable(this.links, flags);
            dest.writeInt(this.buckets_count);
            dest.writeInt(this.comments_received_count);
            dest.writeInt(this.followers_count);
            dest.writeInt(this.followings_count);
            dest.writeInt(this.likes_count);
            dest.writeInt(this.likes_received_count);
            dest.writeInt(this.projects_count);
            dest.writeInt(this.rebounds_received_count);
            dest.writeInt(this.shots_count);
            dest.writeByte(this.can_upload_shot ? (byte) 1 : (byte) 0);
            dest.writeString(this.type);
            dest.writeByte(this.pro ? (byte) 1 : (byte) 0);
            dest.writeString(this.buckets_url);
            dest.writeString(this.followers_url);
            dest.writeString(this.following_url);
            dest.writeString(this.likes_url);
            dest.writeString(this.projects_url);
            dest.writeString(this.shots_url);
            dest.writeString(this.created_at);
            dest.writeString(this.updated_at);
            dest.writeInt(this.members_count);
            dest.writeString(this.members_url);
            dest.writeString(this.team_shots_url);
        }

        public TeamBean() {
        }

        protected TeamBean(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.username = in.readString();
            this.html_url = in.readString();
            this.avatar_url = in.readString();
            this.bio = in.readString();
            this.location = in.readString();
            this.links = in.readParcelable(LinksBean.class.getClassLoader());
            this.buckets_count = in.readInt();
            this.comments_received_count = in.readInt();
            this.followers_count = in.readInt();
            this.followings_count = in.readInt();
            this.likes_count = in.readInt();
            this.likes_received_count = in.readInt();
            this.projects_count = in.readInt();
            this.rebounds_received_count = in.readInt();
            this.shots_count = in.readInt();
            this.can_upload_shot = in.readByte() != 0;
            this.type = in.readString();
            this.pro = in.readByte() != 0;
            this.buckets_url = in.readString();
            this.followers_url = in.readString();
            this.following_url = in.readString();
            this.likes_url = in.readString();
            this.projects_url = in.readString();
            this.shots_url = in.readString();
            this.created_at = in.readString();
            this.updated_at = in.readString();
            this.members_count = in.readInt();
            this.members_url = in.readString();
            this.team_shots_url = in.readString();
        }

        public static final Creator<TeamBean> CREATOR = new Creator<TeamBean>() {
            @Override
            public TeamBean createFromParcel(Parcel source) {
                return new TeamBean(source);
            }

            @Override
            public TeamBean[] newArray(int size) {
                return new TeamBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeParcelable(this.images, flags);
        dest.writeInt(this.views_count);
        dest.writeInt(this.likes_count);
        dest.writeInt(this.comments_count);
        dest.writeInt(this.attachments_count);
        dest.writeInt(this.rebounds_count);
        dest.writeInt(this.buckets_count);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.html_url);
        dest.writeString(this.attachments_url);
        dest.writeString(this.buckets_url);
        dest.writeString(this.comments_url);
        dest.writeString(this.likes_url);
        dest.writeString(this.projects_url);
        dest.writeString(this.rebounds_url);
        dest.writeByte(this.animated ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.team, flags);
        dest.writeStringList(this.tags);
    }

    public ShotEntity() {
    }

    protected ShotEntity(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.images = in.readParcelable(ImagesBean.class.getClassLoader());
        this.views_count = in.readInt();
        this.likes_count = in.readInt();
        this.comments_count = in.readInt();
        this.attachments_count = in.readInt();
        this.rebounds_count = in.readInt();
        this.buckets_count = in.readInt();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.html_url = in.readString();
        this.attachments_url = in.readString();
        this.buckets_url = in.readString();
        this.comments_url = in.readString();
        this.likes_url = in.readString();
        this.projects_url = in.readString();
        this.rebounds_url = in.readString();
        this.animated = in.readByte() != 0;
        this.user = in.readParcelable(UserBean.class.getClassLoader());
        this.team = in.readParcelable(TeamBean.class.getClassLoader());
        this.tags = in.createStringArrayList();
    }

    public static final Parcelable.Creator<ShotEntity> CREATOR = new Parcelable.Creator<ShotEntity>() {
        @Override
        public ShotEntity createFromParcel(Parcel source) {
            return new ShotEntity(source);
        }

        @Override
        public ShotEntity[] newArray(int size) {
            return new ShotEntity[size];
        }
    };
}

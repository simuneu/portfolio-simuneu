package com.simune.portfolio.domain

import com.simune.portfolio.domain.constant.SkillType
import com.simune.portfolio.domain.entity.*
import com.simune.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테스트 데이터 초기화")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "어쩌구상",
                description = "자료구조, 알고리즘",
                host="개최?",
                achievedDate = LocalDate.of(2022,2,22),
                isActive = true
            ),
            Achievement(
                title = "어쩌구상",
                description = "자료구조, 알고리즘",
                host="개최?",
                achievedDate = LocalDate.of(2022,2,22),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "저는 이런 사람",isActive = true ),
            Introduction(content = "그리고 이런 사람",isActive = true ),
            Introduction(content = "이런 저런 사람",isActive = true ),
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/simuneu", isActive = true),
            Link(name = "Twitter", content = "https://twitter.com/simuneu", isActive = false),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "대학교",
            description ="2020",
            startYear = 2022,
            startMonth = 2,
            endYear = 2022,
            endMonth = 3,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content="어쩌구 동아리", isActive = true),
                ExperienceDetail(content="어쩌구 학회", isActive = true),

            )
        )
        val experience2 = Experience(
            title = "대학교2",
            description ="2020",
            startYear = 2022,
            startMonth = 2,
            endYear = 2022,
            endMonth = 3,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content="어쩌구 동아리2", isActive = true),
                ExperienceDetail(content="어쩌구 학회2", isActive = true),
                )
        )
        experienceRepository.saveAll(mutableListOf(experience1,experience2))

        val java = Skill(name="Java", type=SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name="Spring", type=SkillType.LANGUAGE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java,spring))

        val project1 = Project(
            name = "프로젝트1",
            description ="이런저런 내용의 프로젝트",
            startYear = 2022,
            startMonth = 2,
            endYear = 2022,
            endMonth = 3,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "어떤 내용의 머시기 개발", url= null, isActive = true),
                ProjectDetail(content = "어떤 내용의 머시기 개발", url= null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project=project1, skill=java),
                ProjectSkill(project=project1, skill=spring)
            )
        )
        val project2 = Project(
            name = "프로젝트2",
            description ="이런저런 내용의 프로젝트2",
            startYear = 2022,
            startMonth = 2,
            endYear = 2022,
            endMonth = 3,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "어떤 내용의 머시기 개발2", url= null, isActive = true),
                ProjectDetail(content = "어떤 내용의 머시기 개발2", url= null, isActive = true),
                ProjectDetail(content = "Github repository", url= "https://github.com/simuneu", isActive = true),
                )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project= project2, skill=spring),
                ProjectSkill(project= project2, skill=java)
            )
        )
        projectRepository.saveAll(mutableListOf(project1,project2))
    }

}
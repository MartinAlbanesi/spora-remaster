package com.gg.spora.user.domain

import com.gg.spora.grove.domain.interfaces.IGroveRepository
import com.gg.spora.grove.domain.mappers.toForestTree
import com.gg.spora.grove.domain.mappers.toSeedTree
import com.gg.spora.tutorials.data.local.TutorialRepositoryLocal
import com.gg.spora.tutorials.domain.SetTutorialsLocalUseCase
import com.gg.spora.tutorials.domain.repository.ITutorialRepositoryLocal
import com.gg.spora.user.domain.mappers.toLevelCompletedEntity
import com.gg.spora.user.domain.repository.IUserRepositoryLocal
import com.gg.spora.user.domain.repository.IUserRepositoryNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Use case to update the user's local data from the network
 * @param email: String
 */
class UpdateUserLocalDataFromNetworkUseCase @Inject constructor(
    private val userRepositoryNetwork: IUserRepositoryNetwork,
    private val userRepositoryLocal: IUserRepositoryLocal,
    private val groveRepositoryLocal: IGroveRepository,
    private val setTutorialsLocalUseCase: SetTutorialsLocalUseCase
) {
    suspend operator fun invoke(
        email: String
    ) {
        val user = userRepositoryNetwork.getUserByEmailFlow(email).first()
        userRepositoryLocal.setUserLocal(user)
        val listForestTree = user.forestTrees.map { it.toForestTree() }
        for(forestTree in listForestTree){
            groveRepositoryLocal.insertForestTree(forestTree)
        }
        val listSeedTrees = user.seedTrees.map { it.toSeedTree() }
        groveRepositoryLocal.insertSeedTreesList(listSeedTrees)
        userRepositoryLocal.setLevelsCompleted(user.levelsCompleted.map { it.toLevelCompletedEntity(user.id) })

        setTutorialsLocalUseCase(user.tutorialsCompleted)
    }
}
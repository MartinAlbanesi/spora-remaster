package com.gg.spora.grove.data

/*
@AndroidEntryPoint
class CooldownService @Inject constructor(
    private val groveViewModel: GroveViewModel
) : Service() {

    private val cooldownTimers = mutableMapOf<Int, CountDownTimer>()

    override fun onBind(intent: Intent?): IBinder? {
        return null // Not a bound service
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val seedTreeId = intent?.getIntExtra("seedTreeId", -1) ?: -1
        val cooldownDuration = intent?.getLongExtra("cooldownDuration", 0) ?: 0

        if (seedTreeId != -1 && cooldownDuration > 0) {
            startCooldownTimer(seedTreeId, cooldownDuration)
        }

        return START_NOT_STICKY
    }

    private fun startCooldownTimer(seedTreeId: Int, cooldownDuration: Long) {
        cooldownTimers[seedTreeId] = object : CountDownTimer(cooldownDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val currentTrees = groveViewModel.getSeedTrees()
                val treeToUpdate: List<SeedTree> = currentTrees.filter { it.id == seedTreeId }
                treeToUpdate.forEach {
//                    it.nextForestTreeAvailableTime = (millisUntilFinished / 1000)
                }
                groveViewModel.updateTreeState(currentTrees)
            }

            override fun onFinish() {
                val currentTrees = groveViewModel.getSeedTrees()
                groveViewModel.setSeedTrees(currentTrees)
                cooldownTimers.remove(seedTreeId)
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel all timers when the service is destroyed
        cooldownTimers.values.forEach { it.cancel() }
        cooldownTimers.clear()
    }
}
 */
/**
 * Copyright 2018 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public interface RLock extends Lock, RExpirable, RLockAsync {

    void lockInterruptibly(long leaseTime, TimeUnit unit) throws InterruptedException;

    boolean tryLock(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException;

    boolean tryLock(long waitTime, long leaseTime, TimeUnit unit, long modifiedThreadId) throws InterruptedException;

    void lock(long leaseTime, TimeUnit unit);

    boolean forceUnlock();

    boolean isLocked();

    boolean isHeldByCurrentThread();

    int getHoldCount();

    void unlock(long threadId);

}
